import { iPost, iRoot } from '../../Models/post';
import { Component } from '@angular/core';

@Component({
  selector: 'app-active-posts',
  templateUrl: './active-posts.component.html',
  styleUrl: './active-posts.component.scss'
})
export class ActivePostsComponent {
  title = 'EPICBlog';

  postsArr: iPost[] = [];
  dbObj: iRoot = {
    posts: [],
    total: 0,
    skip: 0,
    limit: 0
  };
  randomArr: { title: string, body: string }[] = [];
  details: { title: string, body: string } = {
    title: '',
    body: ''
  };

  actPosts:iPost[]=[]
ngOnInit() {
  fetch('../../../assets/db.json')
  .then(db => db.json())
  .then((db: iRoot) => {
    this.postsArr = db.posts;


      for (let i = 0; i < this.postsArr.length; i++) {
        if(this.postsArr[i].active){
          this.actPosts.push(this.postsArr[i])
        }
      }
    });


  }


}

