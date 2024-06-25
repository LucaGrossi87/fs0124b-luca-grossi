import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { BookBoardComponent } from './book-board/book-board.component';
import { BookLanComponent } from './book-lan/book-lan.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { ConfirmBookingComponent } from './confirm-booking/confirm-booking.component';
import { ManageStationsComponent } from './manage-stations/manage-stations.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BookBoardComponent,
    BookLanComponent,
    AdminLoginComponent,
    ConfirmBookingComponent,
    ManageStationsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
