import { Component, OnInit } from '@angular/core';
import { DateService } from '../../service/date.service';
import { Router, NavigationEnd } from '@angular/router';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  selectedDate: string = '';
  showAlert: boolean = false;

  constructor(private dateService: DateService, private router: Router) { }

  onSelectDate(event: any): void {
    this.selectedDate = event.target.value;
    this.dateService.setSelectedDate(this.selectedDate);
  }

  ngOnInit(): void {
    this.selectedDate = '';

    this.router.events
      .pipe(
        filter((event): event is NavigationEnd => event instanceof NavigationEnd)
      )
      .subscribe((event: NavigationEnd) => {
        if (this.router.url === '/') {
          this.selectedDate = '';
          this.dateService.setSelectedDate('');
        }
      });
  }

  navigateTo(path: string): void {
    if (this.selectedDate) {
      this.router.navigate([path], { queryParams: { date: this.selectedDate } });
    } else {
      this.showAlert = true;
    }
  }

}
