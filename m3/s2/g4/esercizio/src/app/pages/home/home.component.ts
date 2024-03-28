import { Component } from '@angular/core';
import { iPics, iRoot } from '../../models/i-pics';
import { PicsService } from '../../pics.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

constructor(private picsSvc:PicsService){}

  pics:iPics[]=[]

  ngOnInit(){
    this.picsSvc.$pics.subscribe(pics => {
      this.pics = pics
    })
  }
}
