import { Component, OnInit } from '@angular/core';
import { Station } from '../../models/i-stations';
import { BookOpenBoardService } from './book-open-board.service';
import { DateService } from '../../service/date.service';
import { Booking } from '../../models/i-bookings';

@Component({
  selector: 'app-book-open-board',
  templateUrl: './book-open-board.component.html',
  styleUrl: './book-open-board.component.scss'
})
export class BookOpenBoardComponent implements OnInit{

  boards:Station[]=[]
  bookings:Booking[]=[]
  date: string=""

  constructor(private openBoardSvc:BookOpenBoardService, private dateSvc: DateService){}

  ngOnInit(): void {
    this.date = this.dateSvc.getSelectedDate();
    if (!this.date) {
      console.log("Data non selezionata");
      return;
    }

    this.openBoardSvc.getOpenBoards(this.date).subscribe(data => {
      this.boards = data;
    }

  )
  this.openBoardSvc.bookingsByDate(this.date).subscribe(data=>{
    this.bookings= data
    console.log(this.bookings);

  })


  }

}
