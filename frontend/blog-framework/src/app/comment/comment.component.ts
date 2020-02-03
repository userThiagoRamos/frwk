import { Component, NgZone, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CommentDTO } from '../model/comment.model';
import { Post } from '../model/post.model';
import { CommentService } from '../_services/comment.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {
  currentPost: Post;
  commentForm: FormGroup;
  hasError: boolean;
  editMode: boolean;
  currentId: number;
  comments: FormArray;
  initialState: any;
  username: string;

  constructor(
    private service: CommentService,
    private fb: FormBuilder,
    private toastr: ToastrService,
    private router: Router,
    private route: ActivatedRoute,
    private ngZone: NgZone,
    private tokenStorageService: TokenStorageService
  ) {}

  get f() {
    return this.commentForm.controls;
  }
  get p() {
    return this.f.package['controls'];
  }

  get commentItens() {
    return <FormArray>this.commentForm.get('comments');
  }

  ngOnInit() {
    this.currentPost = history.state as Post;
    this.getCommentsForPost();
    this.username = this.tokenStorageService.getUser();
    this.createForm();
  }

  createForm() {
    this.commentForm = this.fb.group({
      comments: this.fb.array([])
    });
    this.initialState = this.commentForm.value;
  }

  getCommentsForPost() {
    if (this.currentPost != null && this.currentPost.id != null) {
      try {
        this.service.getCommentsByIdPost(this.currentPost.id).subscribe(res => {
          const list = res.data;
          list.forEach((c: any) => {
            this.commentItens.controls.push(c.text);
            c.isOwner = c.username === this.username;
          });
        });
      } catch (error) {
        this.toastr.error(error);
      }
    }
  }

  public addComment() {
    const control = this.commentItens;
    control.push(
      this.fb.group({
        id: [''],
        text: ['']
      })
    );
  }
  public saveComment(event, comment: any) {
    const index = event.target['selectedIndex'] - 1;
    const name = event.target.options[event.target.options.selectedIndex].text;
    const array = (<FormArray>this.commentForm.controls['comments']).at(index);
    array['controls'].text.setValue(name);
  }

  delete(index: number) {
    const control = this.commentItens;
    control.removeAt(index);
  }
}
