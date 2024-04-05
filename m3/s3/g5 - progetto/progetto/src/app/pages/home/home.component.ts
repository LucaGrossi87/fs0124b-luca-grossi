import { Component } from '@angular/core';
import { AuthService } from '../../auth/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
  isUserLoggedIn: boolean = false;

  constructor(private authSvc:AuthService){}

  userName:string|undefined=this.getName()

  ngOnInit(){

    this.authSvc.isLoggedIn$.subscribe(data => {

      this.isUserLoggedIn = data;

    })


  }
  getName(){
    return this.authSvc.authSubject.value?.firstName
  }

}
