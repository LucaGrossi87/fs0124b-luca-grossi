import { TestBed } from '@angular/core/testing';

import { BookBoardService } from './book-board.service';

describe('BookBoardService', () => {
  let service: BookBoardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookBoardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
