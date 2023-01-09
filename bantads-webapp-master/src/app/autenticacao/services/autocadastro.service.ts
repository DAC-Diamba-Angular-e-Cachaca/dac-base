import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, Observable, of } from 'rxjs';
import { GerenteService } from 'src/app/gerente/services';
import { AutenticacaoService, Cliente } from 'src/app/shared';
import { environment } from 'src/environments/environment';

const LS_CHAVE: string = 'clientesAutocadastro';

@Injectable({
  providedIn: 'root',
})
export class AutocadastroService {
  autocadastroUrl = `${environment.url.cliente}`;

  constructor(
    private autenticacaoService: AutenticacaoService,
    private http: HttpClient
  ) {}

  cadastrar(cliente: Cliente): Observable<Cliente | null> {
    return this.http
      .post(
        `${this.autocadastroUrl}`,
        cliente,
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
}
