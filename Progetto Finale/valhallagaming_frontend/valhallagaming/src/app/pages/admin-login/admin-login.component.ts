import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../auth/auth.service';
import { Login } from '../../models/i-login';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrl: './admin-login.component.scss'
})

export class AdminLoginComponent {
  login: Login = {
    username: 'admin5',
    password: 'password'
  }

  constructor(
    private authSvc: AuthService,
    private router: Router
  ) { }

  signIn() {
    this.authSvc.login(this.login)
      .subscribe(data => {
        this.router.navigate(['/backoffice']);
        console.log("check");
      }, error => {
        console.error('Errore durante il login:', error);
      });
}}
