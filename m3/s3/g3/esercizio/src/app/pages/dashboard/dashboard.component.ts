import { Component } from '@angular/core';
import { AuthService } from '../../auth/auth.service';
import { iUser } from '../../models/interfaces';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

  constructor(private authSvc:AuthService){}

  user:iUser|undefined;

  ngOnInit(){

    this.authSvc.user$.subscribe(user => {


      this.user = user || undefined;

    })

  }
}
