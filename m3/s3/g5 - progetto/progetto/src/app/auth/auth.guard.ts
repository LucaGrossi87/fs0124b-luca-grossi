import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateChild, GuardResult, MaybeAsync, Router, RouterStateSnapshot } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard {

  constructor(
    private authSvc:AuthService,
    private router:Router//per i redirect
    ){}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): MaybeAsync<GuardResult> {

    if(!this.authSvc.isLoggedIn$){
      this.router.navigate(['/auth/login'])
    }

    return this.authSvc.isLoggedIn$
  }
}
