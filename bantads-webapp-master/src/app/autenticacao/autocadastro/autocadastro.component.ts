import { ViewChild } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Cliente, Estados } from 'src/app/shared';
import { TextFormatter } from 'src/app/shared/helpers/text-formatter';
import { AutocadastroService } from '../services';

@Component({
  selector: 'app-autocadastro',
  templateUrl: './autocadastro.component.html',
  styleUrls: ['./autocadastro.component.scss'],
})
export class AutocadastroComponent implements OnInit {
  @ViewChild('formAutoCadastro') formAutoCadastro!: NgForm;
  cliente!: Cliente;
  estados = Estados;
  loading!: boolean;
  hidePassword = true;

  constructor(
    private autocadastroService: AutocadastroService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.cliente = new Cliente();
  }

  change() {
    console.log(this.cliente.endereco.estado);
  }

  cadastrar() {
    if (this.formAutoCadastro.form.valid) {
      const novoCliente = {
        nome: this.cliente.nome,
        cpf: TextFormatter.removeMask(this.cliente.cpf?.toString()),
        salario: this.cliente.salario,
        usuario: this.cliente.usuario,
        endereco: this.cliente.endereco
      }
      this.autocadastroService
        .cadastrar(novoCliente as Cliente).subscribe({
          next: () => {
            this.loading = false;
            this.toastr.success('Cadastro realizado com sucesso. Consulte seu e-mail para próximos passos.');
            this.router.navigate(['/home']);
          },
          error: (e) => {
            this.loading = false;
            this.toastr.error(
              !!e?.error?.message
                ? e.error.message
                : 'Cadastro inválido.'
            );
          },
        });
    }
  }
}
