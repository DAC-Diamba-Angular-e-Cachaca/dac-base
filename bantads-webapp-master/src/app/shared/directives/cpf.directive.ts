import { Directive, HostListener, ElementRef } from '@angular/core';
import { ControlValueAccessor, NG_VALUE_ACCESSOR } from '@angular/forms';

@Directive({
  selector: '[cpf]',
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: CpfDirective,
      multi: true,
    },
  ],
})
export class CpfDirective implements ControlValueAccessor {
  onChange: any;
  onTouched: any;

  constructor(private el: ElementRef) {}

  @HostListener('keyup', ['$event'])
  onKeyUp($event: any) {
    let valor = $event.target.value;
    valor = valor.toString().replace(/[^0-9.]/g, '');
    valor = valor.replace('.', '').replace('.', '');
    valor = valor.replace('-', '');
    if (valor?.length > 11) {
      valor = valor.substring(0, 11);
    }
    switch (valor?.length) {
      case 4:
        valor = valor.substring(0, 3) + '.' + valor.substring(3, 4);
        break;
      case 5:
        valor = valor.substring(0, 3) + '.' + valor.substring(3, 5);
        break;
      case 6:
        valor = valor.substring(0, 3) + '.' + valor.substring(3, 6);
        break;
      case 7:
        valor =
          valor.substring(0, 3) +
          '.' +
          valor.substring(3, 6) +
          '.' +
          valor.substring(6, 7);
        break;
      case 8:
        valor =
          valor.substring(0, 3) +
          '.' +
          valor.substring(3, 6) +
          '.' +
          valor.substring(6, 8);
        break;
      case 9:
        valor =
          valor.substring(0, 3) +
          '.' +
          valor.substring(3, 6) +
          '.' +
          valor.substring(6, 9);
        break;
      case 10:
        valor =
          valor.substring(0, 3) +
          '.' +
          valor.substring(3, 6) +
          '.' +
          valor.substring(6, 9) +
          '-' +
          valor.substring(9, 10);
        break;
      case 11:
        valor =
          valor.substring(0, 3) +
          '.' +
          valor.substring(3, 6) +
          '.' +
          valor.substring(6, 9) +
          '-' +
          valor.substring(9, 11);
        break;
      default:
        break;
    }

    $event.target.value = valor;
    this.onChange(valor);
  }

  registerOnChange(fn: any): void {
    this.onChange = fn;
  }

  registerOnTouched(fn: any): void {
    this.onTouched = fn;
  }

  writeValue(obj: any): void {
    if (obj === undefined) {
      obj = '';
    }
    this.el.nativeElement.value = obj;
  }
}
