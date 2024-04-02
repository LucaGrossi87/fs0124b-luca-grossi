import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CongratsComponent } from './warning/congrats/congrats.component';



@NgModule({
  declarations: [CongratsComponent],
  imports: [
    CommonModule
  ],
  exports: [
    CongratsComponent
  ]
})
export class SharedModule { }
