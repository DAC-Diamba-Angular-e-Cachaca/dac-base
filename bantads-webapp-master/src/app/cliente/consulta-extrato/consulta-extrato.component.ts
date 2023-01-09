import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, NgForm, NgModel } from '@angular/forms';
import { MatDatepicker } from '@angular/material/datepicker';

import { MatTable } from '@angular/material/table';
import { DateAdapter } from '@angular/material/core';

import { Movimentacao } from 'src/app/shared/models/movimentacao.model';
import { ClienteService } from '../services';

@Component({
  selector: 'app-consulta-extrato',
  templateUrl: './consulta-extrato.component.html',
  styleUrls: ['./consulta-extrato.component.scss']
})
export class ConsultaExtratoComponent implements OnInit {

  @ViewChild('formExtrato') formExtrato!: NgForm;
  @ViewChild(MatTable) table!: MatTable<Movimentacao>;

  movimentacao : Movimentacao[] = [];
  loading!: boolean;
  displayedColumns: string[] = ['data', 'tipo', 'origem', 'destino', 'valor'];
  dataSource = this.movimentacao;
  
  constructor(
    private clienteService: ClienteService,
    private dateAdapter: DateAdapter<Date>) {
      this.dateAdapter.setLocale('pt-BR'); //dd/MM/yyyy 
  }

  ngOnInit(): void {
    
  }

  pesquisar(startDate: string, endDate: string) : void {

    console.log('extrato: ' + startDate + " a " + endDate);
    
    this.clienteService.getMovimentacaoPeriodo().subscribe({
      next: (data: Movimentacao[]) => {
        if (data == null) {
          this.movimentacao = [];
        }
        else {
          this.movimentacao = data;
        }
        this.dataSource = this.movimentacao;  
      }
    });
  }
}