import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { TextFormatter } from 'src/app/shared/helpers/text-formatter';
import { Gerente } from 'src/app/shared/models/gerente.model';

@Component({
  selector: 'app-modal-gerente',
  templateUrl: './modal-gerente.component.html',
  styleUrls: ['./modal-gerente.component.scss']
})
export class ModalGerenteComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: Gerente) { }

  ngOnInit(): void {
    this.data.cpf = TextFormatter.cpfFormatter(this.data.cpf);
  }

}
