import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { iLogin } from '../../models/i-login';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  loginData:iLogin = {
    email:'lucagrossi87@gmail.com',
    password:'password'
  }

  constructor(
    private authSvc:AuthService,
    private router:Router
    ){}

    signIn(){
      this.authSvc.login(this.loginData)
      .subscribe(data => {
        this.router.navigate(['movies'])
      })

    }

}
