import { iPost, iRoot } from '../../Models/post';
import { Component, NgModule } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PostsService } from '../../posts.service';

@Component({
  selector: 'app-posts-detail',
  templateUrl: './posts-detail.component.html',
  styleUrl: './posts-detail.component.scss',
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
  details: iPost = {
    id: 0,
    title: '',
    body: '',
    userId: 0,
    tags: [],
    active: false,
  };

  postsDet:iPost | undefined;
  titleValue:string='';
  activeValue:boolean | null = null


  constructor(private route: ActivatedRoute, private postsSvc:PostsService) { }

  ngOnInit() {

    this.postsArr=this.postsSvc.postsArr

    const postId = this.route.snapshot.paramMap.get('id')
    if (postId) {
      this.postsDet = this.postsArr.find(post => post.id == parseFloat(postId))
      this.titleValue=this.postsDet!.title
      this.activeValue=Boolean(this.postsDet!.active)
      }
  };

  showedForm: boolean = false;

  showForm(): void {
    this.showedForm = !this.showedForm;
  }
  checkValue(){
  console.log(this.activeValue);
  console.log(typeof(this.activeValue));
  }
}
