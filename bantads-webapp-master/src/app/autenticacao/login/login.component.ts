import {
  Component,
  OnInit,
  ViewChild
} from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Autenticacao, AutenticacaoService } from 'src/app/shared';
import { Usuario } from 'src/app/shared/models/usuario.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  hidePassword = true;
  usuario!: Usuario;

  @ViewChild('formLogin') formLogin!: NgForm;

  constructor(
    private autenticacaoService: AutenticacaoService,
    private router: Router,
    private route: ActivatedRoute,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.usuario = new Usuario();

    // this.route.queryParams.subscribe((params) => {
    //   this.message = params['error'];
    // });
  }

  login() {
    if (this.formLogin.form.valid) {
      this.autenticacaoService.login(this.usuario).subscribe({
        next: (res: Autenticacao) => {
          this.autenticacaoService.usuarioLogado = res.usuario;
          if (!!res.token) {
            this.autenticacaoService.token = res.token;
            this.router.navigate([this.autenticacaoService.homeRouterLink]);
          }
          else {
            this.toastr.error('Ocorreu um erro ao logar. Tente novamente.');
            this.autenticacaoService.limparLocalStorage();
          }
        },
        error: () => {
          this.toastr.error('Usuário/Senha inválidos.');
        }
      });
    }
  }

}
