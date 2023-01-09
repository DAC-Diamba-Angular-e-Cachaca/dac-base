import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { firstValueFrom } from 'rxjs';
import { Gerente } from 'src/app/shared/models/gerente.model';
import { ModalGerenteComponent } from '../modal-gerente/modal-gerente.component';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-home-admin',
  templateUrl: './home-admin.component.html',
  styleUrls: ['./home-admin.component.scss'],
})
export class HomeAdminComponent implements OnInit {
  displayedColumns: string[] = [
    'nome',
    'quantidadeContas',
    'saldoPositivo',
    'saldoNegativo',
    'acoes',
  ];
  gerentes: Gerente[] = [];

  constructor(
    private service: AdminService,
    private modalService: MatDialog,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.listarTodos();
  }

  async listarTodos() {
    await firstValueFrom(this.service.listarTodos())
      .then((lista) => {
        this.gerentes = lista;
        if (lista.length == 0) {
          this.toastr.info('Nenhum gerente cadastrado.');
        }
      })
      .catch((e) =>
        this.toastr.error(
          !!e?.error?.message
            ? e.error.message
            : 'Um erro ocorreu ao buscar gerentes.'
        )
      );
  }

  async remover($event: any, gerente: Gerente) {
    $event.preventDefault();
    if (
      confirm('Deseja realmente remover o gerente ' + gerente.nome + '?') &&
      !!gerente.id
    ) {
      await firstValueFrom(this.service.remover(gerente.id))
        .then(() => {
          this.toastr.success('Gerente excluído com sucesso.');
        })
        .catch((e) =>
          this.toastr.error(
            !!e?.error?.message
              ? e.error.message
              : 'Um erro ocorreu ao excluir o gerente.'
          )
        );
    }
  }

  abrirModalGerente(gerente: Gerente) {
    const modalRef = this.modalService.open(ModalGerenteComponent, {
      data: gerente,
      width: '1000px',
    });
  }
}
