import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Post } from '../model/post.model';
import { TokenStorageService } from './token-storage.service';
import { retry, catchError } from 'rxjs/operators';
import { ApiResponse } from '../model/api-response';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  readonly baseUrl = 'http://localhost:8662/api/blog-post/v1/post/';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'X-username': this.tokenStorageService.getUser()
    })
  };

  constructor(
    private http: HttpClient,
    private tokenStorageService: TokenStorageService
  ) {}

  getPosts(): Observable<any> {
    return this.http
      .get<ApiResponse>(this.baseUrl + 'all')
      .pipe(retry(1), catchError(this.errorHandler));
  }

  getPostById(idPost: number): Observable<any> {
    return this.http
      .get<ApiResponse>(this.baseUrl + idPost)
      .pipe(retry(1), catchError(this.errorHandler));
  }

  create(post: Post) {
    return this.http
      .post<ApiResponse>(this.baseUrl, JSON.stringify(post), this.httpOptions)
      .pipe(retry(1), catchError(this.errorHandler));
  }

  edit(post: Post) {
    return this.http
      .put<ApiResponse>(this.baseUrl, JSON.stringify(post), this.httpOptions)
      .pipe(retry(1), catchError(this.errorHandler));
  }

  errorHandler(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.message}\nMessage: ${error.details}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }
}
