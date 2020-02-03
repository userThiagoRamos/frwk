import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Post } from '../model/post.model';
import { PostService } from '../_services/post.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {
  posts: Array<Post>;
  username: string;

  constructor(
    private postService: PostService,
    private router: Router,
    private tokenStorageService: TokenStorageService
  ) {}

  editPost(postDTO: Post) {
    this.router.navigateByUrl('/post-edit', { state: postDTO });
  }

  removePost(post) {
    // this.pos;
  }
  ngOnInit() {
    this.username = this.tokenStorageService.getUser();
    this.postService.getPosts().subscribe(
      res => {
        this.posts = res.data.map(p => {
          p.isOwner = p.username === this.username;
          return p;
        });
      },
      err => {
        console.log(err.message);
      }
    );
  }
}
