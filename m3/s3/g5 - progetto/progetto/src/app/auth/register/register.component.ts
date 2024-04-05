import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { iUsers } from '../../models/i-users';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent {
  registerData:Partial<iUsers> = {}

  constructor(
    private authSvc:AuthService,
    private router:Router
    ){}

  signUp(){
    this.authSvc.register(this.registerData)
    .subscribe(data => {

      this.router.navigate(['auth/login'])

    })
  }
}
