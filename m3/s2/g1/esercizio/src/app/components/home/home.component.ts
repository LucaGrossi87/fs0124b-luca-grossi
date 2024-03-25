import { Component, OnInit } from '@angular/core';
import { iPost, iRoot } from '../../Models/post';
import { PostsService } from '../../posts.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit{
  title = 'EPICBlog';

  postsArr:iPost[]=[]
  dbObj:iRoot={
    posts: [],
    total: 0,
    skip: 0,
    limit: 0
  }

  randomArr: iPost[] = [];
  details: { title: string, body: string, id:number, userId:number; tags:string[],active:boolean } = {
    title: '',
    body: '',
    id: 0,
    userId: 0,
    tags: [],
    active: false
  };

  constructor(private postsSvc:PostsService){}

  ngOnInit(){

    // .getPosts().then(res => {

    //   this.dbObj = res;
    //   this.postsArr = this.dbObj.posts
      console.log(this.postsSvc.postsArr);
      this.postsArr=this.postsSvc.postsArr

      this.randomize();


      }


  randomize() {
    for (let i = 0; i < 4; i++) {
      let randomNum: number = Math.floor(Math.random() * this.postsArr.length);
      this.details.title = this.postsArr[randomNum].title;
      this.details.body = this.postsArr[randomNum].body;
      this.details.id = this.postsArr[randomNum].id;
      this.details.userId = this.postsArr[randomNum].userId;
      this.details.tags = this.postsArr[randomNum].tags;
      this.details.active = this.postsArr[randomNum].active;
      this.randomArr.push({
        ...this.details,
      });

    }
    console.log(this.randomArr);
  }}
