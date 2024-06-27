import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { BookLanComponent } from './pages/book-lan/book-lan.component';
import { AdminLoginComponent } from './pages/admin-login/admin-login.component';
import { ManageStationsComponent } from './pages/manage-stations/manage-stations.component';
import { BookBoardComponent } from './pages/book-board/book-board.component';
import { ConfirmBookingComponent } from './pages/confirm-booking/confirm-booking.component';
import { BookOpenBoardComponent } from './pages/book-open-board/book-open-board.component';
import { BookNewBoardComponent } from './pages/book-new-board/book-new-board.component';
import { WaitConfirmationComponent } from './pages/wait-confirmation/wait-confirmation/wait-confirmation.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'book-table', component: BookBoardComponent },
  { path: 'book-new-board', component: BookNewBoardComponent },
  { path: 'book-open-board', component: BookOpenBoardComponent },
  { path: 'book-lan', component: BookLanComponent },
  { path: 'admin-login', component: AdminLoginComponent },
  { path: 'confirm-bookings', component: ConfirmBookingComponent },
  { path: 'manage-stations', component: ManageStationsComponent },
  { path: 'wait-confirmation', component: WaitConfirmationComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
