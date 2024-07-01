import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environments';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Station } from '../../models/i-stations';
import { Booking } from '../../models/i-bookings';

@Injectable({
  providedIn: 'root'
})
export class BookOpenBoardService {

  private openBoardsUrl=environment.openBoardsUrl
  private openBoardsBookingUrl=environment.openBoardsBookingUrl
  private bookingsByDateUrl=environment.bookingsByDateUrl

  constructor(private http:HttpClient) { }

  getOpenBoards(date:string):Observable<Station[]> {
    return this.http.get<Station[]>(`${this.openBoardsUrl}?date=${date}`)
  }

  bookingsByDate(date:string):Observable<Booking[]> {
    return this.http.get<Booking[]>(`${this.bookingsByDateUrl}?date=${date}`)
  }
}
