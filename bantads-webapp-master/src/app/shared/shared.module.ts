import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';
import { MatTableModule } from '@angular/material/table';
import { RouterModule } from '@angular/router';
import { MatCardModule } from '@angular/material/card';
import { MatExpansionModule } from '@angular/material/expansion';
import { CpfDirective } from './directives/cpf.directive';
import { NumericoDirective } from './directives/numerico.directive';
import { MinimoValidatorDirective } from './directives/minimo-validator.directive';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [CpfDirective, NumericoDirective, MinimoValidatorDirective],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    FlexLayoutModule,
    MatFormFieldModule,
    MatInputModule,
    MatToolbarModule,
    MatButtonModule,
    MatMenuModule,
    MatDialogModule,
    MatTableModule,
    MatIconModule,
    MatCardModule,
    MatExpansionModule,
    ToastrModule.forRoot({
      timeOut: 8000,
      positionClass: 'toast-top-full-width',
      closeButton: true,
    }),
  ],
  exports: [
    CommonModule,
    FormsModule,
    RouterModule,
    FlexLayoutModule,
    MatFormFieldModule,
    MatInputModule,
    MatToolbarModule,
    MatButtonModule,
    MatMenuModule,
    MatDialogModule,
    MatTableModule,
    MatIconModule,
    MatCardModule,
    MatExpansionModule,
    CpfDirective,
    NumericoDirective,
    MinimoValidatorDirective,
    ToastrModule,
  ],
})
export class SharedModule {}
