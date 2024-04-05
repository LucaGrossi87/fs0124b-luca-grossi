import { Component } from '@angular/core';
import { IMovies } from '../../models/i-movies';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment.development';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrl: './movies.component.scss'
})
export class MoviesComponent {

  movies: IMovies[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getMovies();
  }

  getMovies() {
    const moviesUrl = environment.moviesUrl;
    this.http.get<IMovies[]>(moviesUrl).subscribe(
      (movies) => {
        this.movies = movies;
        console.log(movies);

      },
    );
  }
}
