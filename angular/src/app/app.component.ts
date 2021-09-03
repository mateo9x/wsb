import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from './components/user/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  
  isUserLogged = false;
  isCartEmpty = false;
  
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(){
    this.userService.isUserLogged().subscribe((response) => {
      if (response !== false) {
      this.isUserLogged = true;
      }
    });
  }

  logOut(){
    this.userService.logoutUser().subscribe((response) => {
      console.log(response);
    this.isUserLogged = false;
    });
  }
  
}
