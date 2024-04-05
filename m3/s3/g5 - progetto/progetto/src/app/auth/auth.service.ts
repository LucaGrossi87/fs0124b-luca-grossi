import { Injectable } from '@angular/core';
import { iAccess } from '../models/i-access';
import { iUsers } from '../models/i-users';
import { BehaviorSubject, Observable, catchError, map, tap, throwError } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { iLogin } from '../models/i-login';
import { JwtHelperService } from '@auth0/angular-jwt';
import { environment } from '../../environments/environment.development';
import { iMovies } from '../models/i-movies';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  jwtHelper:JwtHelperService = new JwtHelperService()

  authSubject = new BehaviorSubject<iUsers|null>(null);

  user$ = this.authSubject.asObservable()
  isLoggedIn$ = this.user$.pipe(map(user => !!user))


  constructor(
    private http:HttpClient,
    private router:Router
    ) {

      this.restoreUser()

    }

  registerUrl:string = environment.registerUrl
  loginUrl:string = environment.loginUrl

  register(newUser:Partial<iUsers>):Observable<iAccess>{
    return this.http.post<iAccess>(this.registerUrl,newUser)
  }

  login(loginData:iLogin):Observable<iAccess>{
    return this.http.post<iAccess>(this.loginUrl,loginData)
    .pipe(tap(data => {

      this.authSubject.next(data.user)
      localStorage.setItem('accessData', JSON.stringify(data))

      this.autoLogout(data.accessToken)

    }))
  }


  logout(){

    this.authSubject.next(null)
    localStorage.removeItem('accessData')

    this.router.navigate(['/'])

  }

  autoLogout(jwt:string){
    const expDate = this.jwtHelper.getTokenExpirationDate(jwt) as Date;
    const expMs = expDate.getTime() - new Date().getTime();

    setTimeout(()=>{
      this.logout()
    },expMs)
  }

  restoreUser(){

    const userJson = localStorage.getItem('accessData')
    if(!userJson) return;
    const accessData:iAccess = JSON.parse(userJson)
    if(this.jwtHelper.isTokenExpired(accessData.accessToken)) return;

    this.authSubject.next(accessData.user)
    this.autoLogout(accessData.accessToken)

  }

  getAccessToken():string{
    const userJson = localStorage.getItem('accessData')
    if(!userJson) return '';

    const accessData:iAccess = JSON.parse(userJson)
    if(this.jwtHelper.isTokenExpired(accessData.accessToken)) return '';

    return accessData.accessToken
  }

  addToFavorites(movie: iMovies): Observable<any> {
    const favoritesUrl = environment.favsUrl;
    const userJson = localStorage.getItem('accessData');
    if (!userJson) {
      return throwError('Nessun utente loggato');
    }
    const accessData: iAccess = JSON.parse(userJson);
    const userId = accessData.user.id;

    const payload = { userId, movie };

    return this.http.post<any>(favoritesUrl, payload).pipe(
        catchError(error => {
        console.error('Errore durante l\'aggiunta del film ai preferiti nel database:', error);
        return throwError('Errore durante l\'aggiunta del film ai preferiti nel database');
      })
    );
  }


}
