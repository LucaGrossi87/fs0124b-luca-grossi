import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { DetailsComponent } from './pages/details/details.component';
import { BrandComponent } from './pages/brand/brand.component';

const routes: Routes = [
  {
    path:"",
    component:HomeComponent
  },
  {
    path:"details/:model",
    component:DetailsComponent
  },
  {
    path:"brand/:brand",
    component:BrandComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
