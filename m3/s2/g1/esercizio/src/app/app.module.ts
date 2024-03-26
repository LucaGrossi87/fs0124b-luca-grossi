import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ActivePostsComponent } from './components/active-posts/active-posts.component';
import { InactivePostsComponent } from './components/inactive-posts/inactive-posts.component';
import { PostsDetailComponent } from './components/posts-detail/posts-detail.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { SinglePostComponent } from './components/single-post/single-post.component';
import { FormsModule } from '@angular/forms';
import { FormComponent } from './components/posts-detail/form/form.component';
import { RandomColorDirective } from './components/posts-detail/random-color.directive';

@NgModule({
  declarations: [
    AppComponent,
    ActivePostsComponent,
    InactivePostsComponent,
    PostsDetailComponent,
    NavbarComponent,
    HomeComponent,
    SinglePostComponent,
    FormComponent,
    RandomColorDirective,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
