import { UsersService } from './../../services/users.service';
import { Component } from '@angular/core';
import { TodosService } from '../../services/todos.service';
import { iTodos } from '../../models/i-todos';
import { iUsers } from '../../models/i-users';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  todos: iTodos[] = [];
  users: iUsers[] = [];
  filter: string = '';

  constructor(private todosSvc: TodosService, private usersSvc: UsersService) {}

  ngOnInit() {
    this.todos = this.todosSvc.todos;
    this.users = this.usersSvc.users;
  }

  get filteredTodos(): iTodos[] {
    let filtered = this.filter.trim().toLowerCase();
    return this.todos.filter(
      (todo) =>
        filtered == '' ||
        this.users[todo.userId - 1].firstName
          .toLowerCase()
          .includes(filtered) ||
        this.users[todo.userId - 1].lastName.toLowerCase().includes(filtered) ||
        todo.todo.toLowerCase().includes(filtered)
    );
  }

  accomplish(todo: iTodos) {
    this.todosSvc.accomplish(todo);
  }

  getUser(id: number) {
    return this.usersSvc.getUserById(id);
  }
}
