import {
  Component
} from '@angular/core';
import { Router } from '@angular/router';
import { AutenticacaoService, Usuario } from './shared';
import { TipoUsuario } from './shared/models/enum/tipo-usuario';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'BANTADS';
  tipoUsuario = TipoUsuario;

  constructor(
    private router: Router,
    private autenticacaoService: AutenticacaoService
  ) {}

  get usuarioLogado(): Usuario | null {
    return this.autenticacaoService.usuarioLogado;
  }

  get homeRouterLink(): string {
    return this.autenticacaoService.homeRouterLink;
  }

  logout() {
    this.autenticacaoService.logout();
    this.router.navigate(['/home']);
  }
}
