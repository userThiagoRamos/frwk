import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { PostService } from '../_services/post.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  content: string;

  constructor(private postService: PostService) {}

  ngOnInit() {
    this.postService.getPosts().subscribe(
      data => {
        this.content = data.data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
  }
}
