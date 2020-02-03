import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { TokenStorageService } from './token-storage.service';
import { Observable, throwError } from 'rxjs';
import { ApiResponse } from '../model/api-response';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  readonly baseUrl = 'http://localhost:8662/api/blog-comment/v1/comment/';

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

  getCommentsByIdPost(idPost: string): Observable<any> {
    return this.http
      .get<ApiResponse>(this.baseUrl + 'post/' + idPost)
      .pipe(retry(1), catchError(this.errorHandler));
  }

  getCommentById(idComment: number): Observable<any> {
    return this.http
      .get<ApiResponse>(this.baseUrl + idComment)
      .pipe(retry(1), catchError(this.errorHandler));
  }

  create(comment: Comment) {
    return this.http
      .post<ApiResponse>(
        this.baseUrl,
        JSON.stringify(comment),
        this.httpOptions
      )
      .pipe(retry(1), catchError(this.errorHandler));
  }

  edit(comment: Comment) {
    return this.http
      .put<ApiResponse>(this.baseUrl, JSON.stringify(comment), this.httpOptions)
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
