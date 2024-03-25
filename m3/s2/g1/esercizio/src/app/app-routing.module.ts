import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ActivePostsComponent } from './components/active-posts/active-posts.component';
import { InactivePostsComponent } from './components/inactive-posts/inactive-posts.component';
import { PostsDetailComponent } from './components/posts-detail/posts-detail.component';
import { SinglePostComponent } from './components/single-post/single-post.component';

const routes: Routes = [
  {
  path:"",
  component: HomeComponent
  },
  {
  path:"active-posts",
  component: ActivePostsComponent
  },
  {
  path:"inactive-posts",
  component: InactivePostsComponent
  },
  {
  path:"posts-detail/:id",
  component: PostsDetailComponent
  },
  {
    path:"single-post",
    component:SinglePostComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
