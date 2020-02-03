import { Component, OnInit, NgZone } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Post } from '../model/post.model';
import { isEqual } from '../util/Utils';
import { PostService } from '../_services/post.service';

@Component({
  selector: 'app-post-edit',
  templateUrl: './post-edit.component.html',
  styleUrls: ['./post-edit.component.css']
})
export class PostEditComponent implements OnInit {
  postForm: FormGroup;
  hasError: boolean;
  currentPost: Post;
  initialState: any;
  editMode: boolean;
  currentId: number;

  constructor(
    private postService: PostService,
    private fb: FormBuilder,
    private toastr: ToastrService,
    private router: Router,
    private route: ActivatedRoute,
    private ngZone: NgZone
  ) {}

  get f() {
    return this.postForm.controls;
  }
  get p() {
    return this.f.package['controls'];
  }

  ngOnInit() {
    console.log('ola');

    this.currentPost = history.state as Post;
    this.loadPostCommentsAndLinks();
    this.hasError = false;
    this.createForm(this.currentPost);
  }

  loadPostCommentsAndLinks() {
    if (this.currentPost != null && this.currentPost.id != null) {
      this.currentId = Number(this.currentPost.id);
      this.editMode = true;
    } else {
      this.editMode = false;
    }
    console.log(this.editMode);
  }

  createForm(post: any) {
    this.postForm = this.fb.group({
      title: [post.title || '', [Validators.required]],
      text: [post.text || '', [Validators.required]]
    });
    this.initialState = this.postForm.value;
  }

  create() {
    this.hasError = this.postForm.invalid;
    if (!this.hasError) {
      try {
        this.postService.create(this.postForm.value).subscribe(res => {
          this.ngZone.run(() => this.router.navigateByUrl('/post-list'));
        });
      } catch (error) {
        this.toastr.error(error);
      }
      // this.router.navigate(['/post-list']);
    } else if (isEqual(this.initialState, this.postForm.value)) {
      this.toastr.warning('Nenhuma modificação no registro!', 'Post');
    } else {
      this.toastr.error('Erros no formulário!', 'Post');
    }
  }

  edit() {
    this.hasError = this.postForm.invalid;
    if (this.hasError) {
      this.toastr.error(`Erros no formulário`, 'Post');
    } else if (isEqual(this.initialState, this.postForm.value)) {
      this.toastr.warning('Nenhuma modificação no registro!', 'Post');
    } else {
      const editPost = this.postForm.value;
      try {
        editPost.id = this.currentId;
        this.postService.edit(editPost).subscribe(result => {
          this.ngZone.run(() => this.router.navigateByUrl('/post-list'));
          this.toastr.success('Registro atualizado', 'Post');
        });
      } catch (error) {
        this.toastr.error(error);
      }
    }
  }

  cancel() {
    this.router.navigate(['/post-list']);
  }
}
