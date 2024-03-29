import { Component } from '@angular/core';
import { iTodos } from '../../models/i-todos';
import { iUsers } from '../../models/i-users';
import { TodosService } from '../../services/todos.service';
import { UsersService } from '../../services/users.service';

@Component({
  selector: 'app-ongoing',
  templateUrl: './ongoing.component.html',
  styleUrl: './ongoing.component.scss',
})
export class OngoingComponent {
  todos: iTodos[] = [];
  users: iUsers[] = [];

  constructor(private todosSvc: TodosService, private usersSvc: UsersService) {}

  ngOnInit() {
    this.todos = this.todosSvc.todos;
    this.users = this.usersSvc.users;
  }

  accomplish(todo: iTodos) {
    this.todosSvc.accomplish(todo);
  }

  getUser(id: number) {
    return this.usersSvc.getUserById(id);
  }
}
