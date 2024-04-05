import { Component } from '@angular/core';
import { AuthService } from '../../auth/auth.service';
import { iUsers } from '../../models/i-users';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

  constructor(private authSvc:AuthService){}

  user:iUsers|undefined;

  ngOnInit(){

    this.authSvc.user$.subscribe(user => {


      this.user = user || undefined;



    })


  }
}
