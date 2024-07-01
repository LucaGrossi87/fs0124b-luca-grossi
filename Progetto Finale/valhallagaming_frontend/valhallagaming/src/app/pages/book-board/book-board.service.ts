import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environments';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Station } from '../../models/i-stations';

@Injectable({
  providedIn: 'root'
})
export class BookBoardService {

  private boardsUrl=environment.boardsUrl
  constructor(private http: HttpClient) { }

  getBoards():Observable<Station[]> {
    return this.http.get<Station[]>(this.boardsUrl)
  }
}
