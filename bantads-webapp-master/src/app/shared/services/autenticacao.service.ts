import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, Observable } from 'rxjs';
import { TipoUsuario } from 'src/app/shared/models/enum/tipo-usuario';
import { Usuario } from 'src/app/shared/models/usuario.model';
import { environment } from 'src/environments/environment';
import { Autenticacao } from '../models';

@Injectable({
  providedIn: 'root',
})
export class AutenticacaoService {
  loginUrl = `${environment.url.usuario}/login`;
  logoutUrl = `${environment.url.usuario}/logout`;

  constructor(private http: HttpClient,  private router: Router) {}

  public get usuarioLogado(): Usuario {
    const usu = localStorage[environment.localStorage.usuarioLogado];
    return usu ? JSON.parse(usu) : null;
  }

  public set usuarioLogado(usuario: Usuario) {
    localStorage[environment.localStorage.usuarioLogado] =
      JSON.stringify(usuario);
  }

  public get token(): string {
    const token = localStorage[environment.localStorage.tokenSessao];
    return token ? JSON.parse(token) : null;
  }

  public set token(token: string | null) {
    localStorage[environment.localStorage.tokenSessao] = JSON.stringify(token);
  }

  public get homeRouterLink() {
    if (this.usuarioLogado?.tipoUsuario === TipoUsuario.Admin) {
      return '/admin/home';
    } else if (this.usuarioLogado?.tipoUsuario === TipoUsuario.Gerente) {
      return '/gerente/home';
    } else if (this.usuarioLogado?.tipoUsuario === TipoUsuario.Cliente) {
      return '/cliente/home';
    }
    this.logout();
    return '/home';
  }

  getLoginHeaders() {
    if (this.token !== null) {
      const headers = new HttpHeaders({
        'Content-Type': 'application/json',
      });
      return { headers };
    } else {
      this.limparLocalStorage();
      return; // TODO ver com throw error
    }
  }

  getAuthenticationHeaders() {
    if (this.token !== null) {
      const headers = new HttpHeaders({
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
        'x-access-token': this.token,
      });
      return { headers };
    } else {
      this.logout();
      return; // TODO ver com throw error
    }
  }

  login(usuario: Usuario): Observable<Autenticacao | any> {
    return this.http
      .post<Autenticacao>(`${this.loginUrl}`, usuario, this.getLoginHeaders())
      .pipe(catchError(this.handleServiceError<any>()));
  }

  logout() {
    this.limparLocalStorage();
    return this.http
      .get<any>(`${this.logoutUrl}`)
      .pipe(catchError(this.handleServiceError<any>()));
  }

  limparLocalStorage() {
    delete localStorage[environment.localStorage.usuarioLogado];
    delete localStorage[environment.localStorage.tokenSessao];
  }

  handleServiceError<T>() {
    return (error: any): Observable<T> => {
      if (error.status == 401) {
        this.logout();
        this.router.navigate(['/home']);
      }
      throw error;
    };
  }
}
