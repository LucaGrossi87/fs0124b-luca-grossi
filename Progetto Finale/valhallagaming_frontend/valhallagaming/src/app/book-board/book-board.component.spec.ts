import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookBoardComponent } from './book-board.component';

describe('BookBoardComponent', () => {
  let component: BookBoardComponent;
  let fixture: ComponentFixture<BookBoardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BookBoardComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BookBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
