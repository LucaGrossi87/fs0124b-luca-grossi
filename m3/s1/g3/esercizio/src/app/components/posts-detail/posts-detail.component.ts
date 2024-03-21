import { iPost, iRoot } from '../../Models/post';
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-posts-detail',
  templateUrl: './posts-detail.component.html',
  styleUrl: './posts-detail.component.scss'
})

export class PostsDetailComponent {
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

  postsDet:iPost | undefined;

  constructor(private route: ActivatedRoute) { }

ngOnInit() {
  fetch('../../../assets/db.json')
  .then(db => db.json())
  .then((db: iRoot) => {
    this.postsArr = db.posts;


    const postId = this.route.snapshot.paramMap.get('id')
    if (postId) {
      this.postsDet = this.postsArr.find(post => post.id == parseFloat(postId))
    }
    });


  }


}
