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

  ngOnInit(){

    this.authSvc.isLoggedIn$.subscribe(data => {

      this.isUserLoggedIn = data;

    })

  }
}
