import { Directive, Input, OnInit } from '@angular/core';
import { NG_VALIDATORS, Validator, FormControl } from '@angular/forms';

@Directive({
  selector: '[minimoValidator]',
  providers: [
    {
      provide: NG_VALIDATORS,
      useExisting: MinimoValidatorDirective,
      multi: true,
    },
  ],
})
export class MinimoValidatorDirective implements Validator, OnInit {
  @Input('valorMinimo') valorMinimo: string = '0';

  constructor() {}
  ngOnInit(): void {}

  validate(control: FormControl) {
    let v: number = +control.value;
    if (isNaN(v)) {
      return { minimo: true, requiredValue: +this.valorMinimo };
    }
    if (v < 18) {
      return { minimo: true, requiredValue: +this.valorMinimo };
    }
    return null;
  }
}
