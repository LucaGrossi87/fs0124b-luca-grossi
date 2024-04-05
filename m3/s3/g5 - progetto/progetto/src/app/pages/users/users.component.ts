import { Component } from '@angular/core';
import { AuthService } from '../../auth/auth.service';
import { environment } from '../../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { iUsers } from '../../models/i-users';


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrl: './users.component.scss'
})
export class UsersComponent {

  users: iUsers[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getUsers();
  }

  getUsers() {
    const usersUrl = environment.usersUrl;
    this.http.get<iUsers[]>(usersUrl).subscribe(
      (users) => {
        this.users = users;
      },
    );
  }
}
