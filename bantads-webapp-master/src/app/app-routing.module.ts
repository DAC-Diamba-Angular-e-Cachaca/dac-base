import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {
  AutocadastroComponent,
  HomeComponent,
  LoginComponent,
} from './autenticacao';
import { HomeAdminComponent } from './admin/home-admin/home-admin.component';
import { InserirEditarGerenteComponent } from './admin/inserir-editar-gerente/inserir-editar-gerente.component';
import { HomeGerenteComponent } from './gerente';
import { ConsultaExtratoComponent, HomeClienteComponent } from './cliente';
import { ConsultarClientesComponent } from './gerente/consultar-clientes/consultar-clientes.component';
import { ConsultarClienteComponent } from './gerente/consultar-cliente/consultar-cliente.component';
import { ConsultarTopClientesComponent } from './gerente/consultar-top-clientes/consultar-top-clientes.component';

const routes: Routes = [
  // Autenticação
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  // Autocadastro
  { path: 'autocadastro', component: AutocadastroComponent },
  // Admin
  { path:'admin', redirectTo: 'admin/home', pathMatch: 'full' },
  { path:'admin/home', component: HomeAdminComponent },
  { path:'admin/novo-gerente', component: InserirEditarGerenteComponent },
  { path:'admin/editar-gerente/:id', component: InserirEditarGerenteComponent },
  {
    path: 'admin/editar-gerente/:id',
    component: InserirEditarGerenteComponent,
  },
  // Gerente
  { path:'gerente', redirectTo: 'gerente/home', pathMatch: 'full' },
  { path:'gerente/home', component: HomeGerenteComponent },
  { path: 'gerente/consultar-clientes', component: ConsultarClientesComponent },
  { path: 'gerente/consultar-cliente', component: ConsultarClienteComponent },
  { path: 'gerente/consultar-top-clientes', component: ConsultarTopClientesComponent },
  // Cliente
  { path: 'cliente', redirectTo: 'cliente/home', pathMatch: 'full' },
  { path: 'cliente/home', component: HomeClienteComponent },
  { path: 'cliente/extrato', component: ConsultaExtratoComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
