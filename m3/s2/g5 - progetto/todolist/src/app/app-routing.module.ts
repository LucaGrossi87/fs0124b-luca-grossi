import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { UsersComponent } from './pages/users/users.component';
import { CompletedComponent } from './pages/completed/completed.component';
import { OngoingComponent } from './pages/ongoing/ongoing.component';

const routes: Routes = [
  {
    path:"",
    component: HomeComponent
  },
  {
    path:"users",
    component: UsersComponent
  },
  {
    path:"completed",
    component: CompletedComponent
  },
  {
    path:"ongoing",
    component: OngoingComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
