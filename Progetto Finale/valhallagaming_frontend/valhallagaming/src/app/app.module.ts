import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { BookBoardComponent } from './pages/book-board/book-board.component';
import { BookLanComponent } from './pages/book-lan/book-lan.component';
import { AdminLoginComponent } from './pages/admin-login/admin-login.component';
import { ConfirmBookingComponent } from './pages/confirm-booking/confirm-booking.component';
import { ManageStationsComponent } from './pages/manage-stations/manage-stations.component';
import { HeaderComponent } from './components/header/header.component';
import { BookNewBoardComponent } from './pages/book-new-board/book-new-board.component';
import { BookOpenBoardComponent } from './pages/book-open-board/book-open-board.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BookBoardComponent,
    BookLanComponent,
    AdminLoginComponent,
    ConfirmBookingComponent,
    ManageStationsComponent,
    HeaderComponent,
    BookNewBoardComponent,
    BookOpenBoardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
