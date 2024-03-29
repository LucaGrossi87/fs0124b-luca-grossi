import { Component } from '@angular/core';
import { iTodos } from '../../models/i-todos';
import { iUsers } from '../../models/i-users';
import { UsersService } from '../../services/users.service';
import { TodosService } from '../../services/todos.service';

@Component({
  selector: 'app-completed',
  templateUrl: './completed.component.html',
  styleUrl: './completed.component.scss',
})
export class CompletedComponent {
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
