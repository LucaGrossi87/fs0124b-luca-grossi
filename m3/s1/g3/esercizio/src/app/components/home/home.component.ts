import { Component } from '@angular/core';
import { iPost, iRoot } from '../../Models/post';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
  title = 'EPICBlog';

  postsArr:iPost[]=[]
  dbObj:iRoot={
    posts: [],
    total: 0,
    skip: 0,
    limit: 0
  }

  randomArr: iPost[] = [];
  details: { title: string, body: string } = {
    title: '',
    body: ''
  };

  ngOnInit() {
    fetch('../../../assets/db.json')
      .then(db => db.json())
      .then((db: iRoot) => {
        this.postsArr = db.posts;
        this.randomize();
      });
  }

  randomize() {
    for (let i = 0; i < 4; i++) {
      let randomNum: number = Math.floor(Math.random() * this.postsArr.length);
      this.details.title = this.postsArr[randomNum].title;
      this.details.body = this.postsArr[randomNum].body;
      this.randomArr.push({
        ...this.details,
        id: 0,
        userId: 0,
        tags: [],
        active: false
      });
    }
  }
}

