import { iPost } from './../../Models/post';
import { Component, OnInit } from '@angular/core';
import { PostsService } from '../../posts.service';

@Component({
  selector: 'app-single-post',
  templateUrl: './single-post.component.html',
  styleUrl: './single-post.component.scss'
})
export class SinglePostComponent implements OnInit {

  postsArr:iPost[]=[]
  tagsArr:string[]=[]
  filteredArr:iPost[]=[]
  selectedTag:string=''

  constructor(private postsSvc:PostsService){}

  ngOnInit(){

    this.postsArr=this.postsSvc.postsArr
    this.filteredArr=this.postsArr

    for (let i = 0; i < this.postsArr.length; i++) {
      const p:iPost = this.postsArr[i];
      for (let j = 0; j < p.tags.length; j++) {
        const t:string = p.tags[j];
        if (!this.tagsArr.includes(t)) {
          this.tagsArr.push(t)
        }
      }
    }
    console.log(this.filteredArr);
  }

  filtered(tag: string) {
    this.postsSvc.filtered(tag);
    this.filteredArr = this.postsSvc.filteredArr;
    this.selectedTag=tag
    }
  }



