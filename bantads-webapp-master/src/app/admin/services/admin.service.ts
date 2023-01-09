import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, Observable } from 'rxjs';
import { AutenticacaoService, Usuario } from 'src/app/shared';
import { Gerente } from 'src/app/shared/models/gerente.model';
import { environment } from 'src/environments/environment';

const LS_CHAVE: string = 'gerentes';

@Injectable({
  providedIn: 'root',
})
export class AdminService {
  gerenteUrl = `${environment.url.gerente}`;

  constructor(
    private autenticacaoService: AutenticacaoService,
    private http: HttpClient
  ) {}

  listarTodos(): Observable<Gerente[]> {
    return this.http
      .get<Gerente[]>(
        `${this.gerenteUrl}/contas`,
        this.autenticacaoService.getAuthenticationHeaders()
      )
      .pipe(catchError(this.autenticacaoService.handleServiceError<any>()));
  }

  inserir(gerente: Gerente): Observable<any> {
    return this.http
      .post(
        `${this.gerenteUrl}`,
        gerente,
        this.autenticacaoService.getAuthenticationHeaders()
      )
      .pipe(
        map((ent) => {
          if (ent) {
            return ent;
          }
          return;
        }),
        catchError(this.autenticacaoService.handleServiceError<any>())
      );
  }

  buscarPorId(id: string): Observable<Gerente> {
    return this.http
      .get<Gerente>(
        `${this.gerenteUrl}/${id}`,
        this.autenticacaoService.getAuthenticationHeaders()
      )
      .pipe(catchError(this.autenticacaoService.handleServiceError<any>()));
  }

  atualizar(gerente: Gerente): Observable<Gerente> {
    return this.http
      .put<Gerente>(
        `${this.gerenteUrl}/${gerente.id}`,
        gerente,
        this.autenticacaoService.getAuthenticationHeaders()
      )
      .pipe(catchError(this.autenticacaoService.handleServiceError<any>()));
  }

  remover(id: string): Observable<any> {
    return this.http
      .delete(
        `${this.gerenteUrl}/${id}`,
        this.autenticacaoService.getAuthenticationHeaders()
      )
      .pipe(catchError(this.autenticacaoService.handleServiceError<any>()));
  }
}
