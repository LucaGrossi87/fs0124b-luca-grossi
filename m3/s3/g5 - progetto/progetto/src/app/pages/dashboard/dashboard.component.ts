import { Component } from '@angular/core';
import { AuthService } from '../../auth/auth.service';
import { iUsers } from '../../models/i-users';
import { iFavs } from '../../models/i-favs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment.development';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {
  user: iUsers | null | undefined;
  favoriteMovies: iFavs[] = [];

  constructor(private authSvc: AuthService, private http: HttpClient) { }

  ngOnInit() {
    this.authSvc.user$.subscribe(user => {
      this.user= user;
      if (this.user) {
        this.getFavoriteMovies(this.user.id);
      }
    });
  }

  getFavoriteMovies(userId: number) {
    const favoritesUrl = environment.favsUrl;
    this.http.get<iFavs[]>(favoritesUrl + `?userId=${userId}`).subscribe(
      (favoriteMovies) => {
        this.favoriteMovies = favoriteMovies;
      },
    );
  }
}
