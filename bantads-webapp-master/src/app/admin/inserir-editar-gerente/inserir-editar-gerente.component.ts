import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { firstValueFrom } from 'rxjs';
import { TextFormatter } from 'src/app/shared/helpers/text-formatter';
import { Gerente } from 'src/app/shared/models/gerente.model';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-inserir-editar-gerente',
  templateUrl: './inserir-editar-gerente.component.html',
  styleUrls: ['./inserir-editar-gerente.component.scss'],
})
export class InserirEditarGerenteComponent implements OnInit {
  novoGerente: boolean = true;
  @ViewChild('formGerente') formGerente!: NgForm;
  gerente: Gerente = new Gerente();
  loading!: boolean;
  id!: string;

  constructor(
    private adminService: AdminService,
    private route: ActivatedRoute,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.loading = false;

    this.id = this.route.snapshot.params['id']?.toString();
    this.novoGerente = !this.id;

    this.verificarGerente();
  }

  async verificarGerente() {
    if (!this.novoGerente) {
      await firstValueFrom(this.adminService.buscarPorId(this.id))
        .then((gerente: Gerente) => {
          gerente.cpf = TextFormatter.cpfFormatter(gerente.cpf?.toString());
          this.gerente = gerente;
        })
        .catch((e) => {
          this.toastr.error(
            !!e?.error?.message ? e.error.message : 'Erro ao buscar gerente.'
          );
          this.router.navigate(['/admin/home']);
        });
    }
  }

  salvar(): void {
    this.loading = true;
    if (this.formGerente.valid) {
      this.gerente.cpf = TextFormatter.removeMask(this.gerente.cpf?.toString());
      if (this.novoGerente) {
        this.adminService.inserir(this.gerente).subscribe({
          next: () => {
            this.loading = false;
            this.toastr.success('Gerente cadastrado com sucesso.');
            this.router.navigate(['/admin/home']);
          },
          error: (e) => {
            this.loading = false;
            this.gerente.cpf = TextFormatter.cpfFormatter(this.gerente.cpf?.toString());
            this.toastr.error(
              !!e?.error?.message
                ? e.error.message
                : 'Erro ao cadastrar gerente.'
            );
          },
        });
      } else {
        this.adminService.atualizar(this.gerente).subscribe({
          next: () => {
            this.loading = false;
            this.toastr.success('Gerente alterado com sucesso.');
            this.router.navigate(['/admin/home']);
          },
          error: (e) => {
            this.loading = false;
            this.gerente.cpf = TextFormatter.cpfFormatter(this.gerente.cpf?.toString());
            this.toastr.error(
              !!e?.error?.message
                ? e.error.message
                : 'Erro ao alterar gerente.'
            );
          },
        });
      }
    }
  }
}
