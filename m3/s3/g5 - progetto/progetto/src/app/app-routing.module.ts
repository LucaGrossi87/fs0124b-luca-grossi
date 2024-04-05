import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth/auth.guard';
import { GuestGuard } from './auth/guest.guard';

const routes: Routes = [{ path: '', loadChildren: () => import('./pages/home/home.module').then(m => m.HomeModule) },
{ path: 'dashboard', loadChildren: () => import('./pages/dashboard/dashboard.module').then(m => m.DashboardModule), canActivate: [AuthGuard] },
{ path: 'users', loadChildren: () => import('./pages/users/users.module').then(m => m.UsersModule), canActivate: [AuthGuard] },
{ path: 'movies', loadChildren: () => import('./pages/movies/movies.module').then(m => m.MoviesModule), canActivate: [AuthGuard] },
{ path: 'auth', loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule), canActivate: [GuestGuard], canActivateChild: [GuestGuard]}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
