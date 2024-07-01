import { Station } from './../../models/i-stations';
import { BookNewBoardService } from './book-new-board.service';
import { Component, OnInit } from '@angular/core';
import { DateService } from '../../service/date.service';
import { UserService } from '../../service/user.service';
import { User } from '../../models/i-users';

@Component({
  selector: 'app-book-new-board',
  templateUrl: './book-new-board.component.html',
  styleUrl: './book-new-board.component.scss'
})
export class BookNewBoardComponent implements OnInit{

  boards: Station[]=[]
  date: string = ""
  firstName: string = "";
  lastName: string = "";
  username: string = "";
  email:string="email";
  guests:number=0
  open: boolean = false;
  guestNumbers: number[] = [2, 3, 4, 5, 6, 7, 8, 9, 10];
  seats:number=0
  boardId:number|undefined
  chosenBoard:Station | undefined

  constructor(private newBoardSvc:BookNewBoardService, private dateSvc: DateService, private userSvc: UserService){}

  ngOnInit(): void {
    this.date = this.dateSvc.getSelectedDate();
    if (!this.date) {
      console.log("Data non selezionata");
      return;
    }

    this.newBoardSvc.getNewBoards(this.date).subscribe(data => {
      this.boards = data;
    })
  }

  onSeatSelected(board: Station): void {
    this.seats = board.seatsTotal;
  }

  prenota(): void {
    if (this.firstName && this.lastName && this.email) {

      const newUser: User = {
        firstName: this.firstName,
        lastName: this.lastName,
        username: this.username,
        email: this.email
      };

      let userIdToUse: number | undefined;

      this.userSvc.createUser(newUser).subscribe(user => {
        if (user.id !== undefined) {
          userIdToUse = user.id;

          if (!this.open) {
            this.newBoardSvc.newBoardBooking(this.date, this.guests, userIdToUse, this.open).subscribe(() => {
              console.log(`Prenotazione effettuata per ${this.firstName} ${this.lastName} alla data ${this.date}`);
            });
          } else {
            this.newBoardSvc.getNewBoardById(this.date, this.seats).subscribe(boards => {
              if (boards.length > 0) {
                this.chosenBoard = boards[0];
                this.boardId = this.chosenBoard.id;
                console.log(this.date+this.guests+userIdToUse+this.open+this.boardId);

                this.newBoardSvc.newBoardBookingById(this.date, this.guests, userIdToUse || 0, this.open, this.boardId || 0).subscribe(() => {
                  console.log(`Prenotazione effettuata per ${this.firstName} ${this.lastName} alla data ${this.date}`);
                });
              } else {
                console.log("Nessun board disponibile trovato per i criteri specificati");
              }
            });
          }
        } else {
          console.log("Errore nella creazione dell'utente: ID non definito");
        }
      });
    } else {
      console.log("Inserisci nome, cognome e email per prenotare");
    }
  }
}
