import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { BookLanComponent } from './book-lan/book-lan.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { ManageStationsComponent } from './manage-stations/manage-stations.component';
import { BookBoardComponent } from './book-board/book-board.component';
import { ConfirmBookingComponent } from './confirm-booking/confirm-booking.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'book-table', component: BookBoardComponent },
  { path: 'book-lan', component: BookLanComponent },
  { path: 'admin-login', component: AdminLoginComponent },
  { path: 'confirm-bookings', component: ConfirmBookingComponent },
  { path: 'manage-stations', component: ManageStationsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
