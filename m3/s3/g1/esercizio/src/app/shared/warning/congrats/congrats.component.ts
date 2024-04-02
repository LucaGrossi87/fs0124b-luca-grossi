import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-congrats',
  templateUrl: './congrats.component.html',
  styleUrl: './congrats.component.scss'
})
export class CongratsComponent {

  @Input() testo!:string;

}
