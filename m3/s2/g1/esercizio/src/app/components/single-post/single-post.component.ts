import { Component, OnInit } from '@angular/core';
import { iPost } from '../../Models/post';
import { PostsService } from '../../posts.service';

@Component({
  selector: 'app-single-post',
  templateUrl: './single-post.component.html',
  styleUrl: './single-post.component.scss'
})
export class SinglePostComponent implements OnInit {

  postsArr:iPost[]=[]

  constructor(private postsSvc:PostsService){}

  ngOnInit(){
      console.log(this.postsSvc.postsArr);
      this.postsArr=this.postsSvc.postsArr

      }

}
