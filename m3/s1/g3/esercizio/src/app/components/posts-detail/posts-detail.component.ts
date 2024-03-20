import { iPost, iRoot } from '../../Models/post';
import { Component } from '@angular/core';

@Component({
  selector: 'app-posts-detail',
  templateUrl: './posts-detail.component.html',
  styleUrl: './posts-detail.component.scss'
})

export class PostsDetailComponent {
  title = 'EPICBlog';

  postsArr:iPost[]=[]
  dbObj:iRoot={
    posts: [],
    total: 0,
    skip: 0,
    limit: 0
  }

  ngOnInit(){

    fetch('../../../assets/db.json')
    .then(db => db.json())
    .then((db:iRoot) => this.dbObj = db)
  }
}
