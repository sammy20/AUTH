import { Component, Input} from '@angular/core';
import { AbstractControl } from '@angular/forms';

@Component({
  selector: 'validation-errors',
  templateUrl: './validation-errors.component.html',
  styleUrls: ['./validation-errors.component.css']
})
export class ValidationErrorsComponent {
  @Input() abstractControl: AbstractControl;
}
