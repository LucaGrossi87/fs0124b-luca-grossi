import { iPost, iRoot } from '../../Models/post';
import { Component } from '@angular/core';

@Component({
  selector: 'app-active-posts',
  templateUrl: './active-posts.component.html',
  styleUrl: './active-posts.component.scss'
})
export class ActivePostsComponent {
  title = 'EPICBlog';

  postsArr:iPost[]=[]
  dbObj:iRoot={
    posts: [],
    total: 0,
    skip: 0,
    limit: 0
  }
  randomArr:{title:string,body:string}[]=[]
  details:{title:string, body:string}={
    title:'',
    body:''
  }

  ngOnInit(){

    fetch('../../../assets/db.json')
    .then(db => db.json())
    .then((db:iRoot) => this.dbObj = db)
    .then(
      for (let i = 0; i <4; i++) {
        let randomNum:number = Math.floor(Math.random() * this.dbObj.posts.length)
        this.details.title=this.dbObj.posts[randomNum].title
        this.details.body=this.dbObj.posts[randomNum].body
        this.randomArr.push(this.details)
      })
  }
  }
