import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appRandomColor]'
})
export class RandomColorDirective {

  constructor(private ref:ElementRef) { }

  letters:string = '0123456789ABCDEF';
  color:string = '#';

  getRandomColor() {
        this.color = "#";
        for (var i = 0; i < 6; i++) {
            this.color += this.letters[Math.floor(Math.random() * 16)];
        }
        return this.color
      }

  ngOnInit(){

    this.ref.nativeElement.style.color = this.getRandomColor()
  }

}
