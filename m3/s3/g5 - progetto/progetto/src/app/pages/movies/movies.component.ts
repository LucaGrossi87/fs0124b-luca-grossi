import { Component } from '@angular/core';
import { iMovies } from '../../models/i-movies';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment.development';
import { AuthService } from '../../auth/auth.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrl: './movies.component.scss'
})
export class MoviesComponent {

  movies: iMovies[] = [];

  constructor(private http: HttpClient, private authSvc: AuthService) { }

  ngOnInit() {
    this.getMovies();
  }

  getMovies() {
    const moviesUrl = environment.moviesUrl;
    this.http.get<iMovies[]>(moviesUrl).subscribe(
      (movies) => {
        this.movies = movies;
      },
    );
  }

  addToFavs(movie: iMovies) {
    this.authSvc.addToFavorites(movie).subscribe()
}
}
