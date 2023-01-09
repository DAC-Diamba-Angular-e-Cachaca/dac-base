import { NgModule } from '@angular/core';
import { HomeComponent } from './home/home.component';
import { AutocadastroComponent } from './autocadastro/autocadastro.component';
import { LoginComponent } from './login/login.component';
import { SharedModule } from '../shared/shared.module';
import { MatSelectModule } from '@angular/material/select';
import { IConfig, NgxMaskModule } from 'ngx-mask';
import { NgxCurrencyModule } from 'ngx-currency';
import { AutenticacaoService } from '../shared';

export const options: Partial<IConfig> | (() => Partial<IConfig>) = {};

@NgModule({
  declarations: [HomeComponent, AutocadastroComponent, LoginComponent],
  imports: [
    SharedModule,
    MatSelectModule,
    NgxMaskModule.forRoot(),
    NgxCurrencyModule
  ],
  exports: [HomeComponent, LoginComponent],
  providers: [AutenticacaoService],
})
export class AutenticacaoModule {}
