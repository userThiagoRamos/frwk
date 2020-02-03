import { Injectable } from '@angular/core';
import * as jwt_decode from 'jwt-decode';

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {
  constructor() {}

  signOut() {
    window.sessionStorage.clear();
  }

  public saveToken(token: any) {
    if (token) {
      window.sessionStorage.removeItem(TOKEN_KEY);
      window.sessionStorage.setItem(TOKEN_KEY, token.token);
    }
  }

  public getToken(): string {
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public saveUser(data) {
    window.sessionStorage.removeItem(USER_KEY);
    if (data && data.token) {
      const decodeToken = jwt_decode(data.token);
      const user = decodeToken.sub;
      window.sessionStorage.setItem(USER_KEY, user);
    }
  }

  public getUser() {
    return sessionStorage.getItem(USER_KEY);
  }
}
