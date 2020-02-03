import { Component, OnInit } from "@angular/core";
import { TokenStorageService } from "./_services/token-storage.service";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent implements OnInit {
  private roles: string[];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username: string;

  constructor(private tokenStorageService: TokenStorageService) {}

  ngOnInit() {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();

      this.showAdminBoard = true;
      this.showModeratorBoard = true;

      this.username = user;
    }
  }

  logout() {
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}
