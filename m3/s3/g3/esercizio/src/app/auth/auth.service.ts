import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { BehaviorSubject, Observable, map, tap } from 'rxjs';
import { iAccess, iLogin, iUser } from '../models/interfaces';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from '../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  jwtHelper:JwtHelperService = new JwtHelperService()

  authSubject = new BehaviorSubject<iUser|null>(null);

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

  register(newUser:Partial<iUser>):Observable<iAccess>{
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
}
