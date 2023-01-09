import { NgModule } from '@angular/core';
import { SharedModule } from '../shared';
import { ConsultarClienteComponent } from './consultar-cliente/consultar-cliente.component';
import { ConsultarClientesComponent } from './consultar-clientes/consultar-clientes.component';
import { ConsultarTopClientesComponent } from './consultar-top-clientes/consultar-top-clientes.component';
import { HomeGerenteComponent } from './home-gerente/home-gerente.component';
import { ModalClienteComponent } from './modal-cliente/modal-cliente.component';
import { ModalReprovarClienteComponent } from './modal-reprovar-cliente/modal-reprovar-cliente.component';

@NgModule({
  declarations: [
    HomeGerenteComponent,
    ConsultarClientesComponent,
    ConsultarClienteComponent,
    ConsultarTopClientesComponent,
    ModalClienteComponent,
    ModalReprovarClienteComponent,
  ],
  imports: [SharedModule],
})
export class GerenteModule {}
