import { NgModule } from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { HomeAdminComponent } from './home-admin/home-admin.component';
import { InserirEditarGerenteComponent } from './inserir-editar-gerente/inserir-editar-gerente.component';
import { ModalGerenteComponent } from './modal-gerente/modal-gerente.component';
import { AdminService } from './services/admin.service';

@NgModule({
  declarations: [
    HomeAdminComponent,
    InserirEditarGerenteComponent,
    ModalGerenteComponent,
  ],
  imports: [
    SharedModule
  ],
  exports: [],
  providers: [AdminService],
})
export class AdminModule {}
