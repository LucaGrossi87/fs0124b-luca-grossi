import { NavbarComponent } from './../../../../../m3/s2/g1/esercizio/src/app/components/navbar/navbar.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';

import { BookLanComponent } from './pages/book-lan/book-lan.component';
import { AdminLoginComponent } from './pages/admin-login/admin-login.component';
import { ConfirmBookingComponent } from './pages/confirm-booking/confirm-booking.component';
import { HeaderComponent } from './components/header/header.component';
import { BookNewBoardComponent } from './pages/book-new-board/book-new-board.component';
import { BookOpenBoardComponent } from './pages/book-open-board/book-open-board.component';
import { FormsModule } from '@angular/forms';
import { WaitConfirmationComponent } from './pages/wait-confirmation/wait-confirmation/wait-confirmation.component';
import { AuthInterceptor } from './auth/auth.interceptor';
import { FooterComponent } from './components/footer/footer.component';
import { ContactsComponent } from './pages/contacts/contacts.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,

    BookLanComponent,
    AdminLoginComponent,
    ConfirmBookingComponent,
    HeaderComponent,
    BookNewBoardComponent,
    BookOpenBoardComponent,
    WaitConfirmationComponent,
    FooterComponent,
    NavbarComponent,
    ContactsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi:true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
