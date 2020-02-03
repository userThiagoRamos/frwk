import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BlogConstants } from '../constants/blog.constants';
import { ApiResponse } from '../model/api-response';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) {}

  getLinks(): Observable<any> {
    return this.http.get(BlogConstants.LINK_API_URL + 'all', {
      responseType: 'text'
    });
  }

  getComments(): Observable<any> {
    return this.http.get(BlogConstants.COMMENT_API_URL + 'all', {
      responseType: 'text'
    });
  }


}
