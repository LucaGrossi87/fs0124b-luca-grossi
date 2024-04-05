import { Component } from '@angular/core';
import { AuthService } from '../../auth/auth.service';
import { environment } from '../../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { iUsers } from '../../models/i-users';
import { iFavs } from '../../models/i-favs';
import { iMovies } from '../../models/i-movies';


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrl: './users.component.scss'
})
export class UsersComponent {
  users: iUsers[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getUsersFavs();
  }

  getUsersFavs() {
    const usersUrl = environment.usersUrl;
    const favoritesUrl = environment.favsUrl;
    this.http.get<iUsers[]>(usersUrl).subscribe(
      (users) => {
        this.users = users;
        this.users.forEach(user => {
          this.http.get<iFavs[]>(favoritesUrl + `?userId=${user.id}`).subscribe(
            (favorite) => {
              user.favMov = favorite;
            },
          );
        });
      },
    );

  }
}
