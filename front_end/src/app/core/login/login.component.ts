import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  @Output() userLogin = new EventEmitter();
  public username;
  public password;
  public userDetail;

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  onLogIn() {
    this.userService.userLogin(this.username).then(response => {
      this.userDetail = response;
      if (this.password == this.userDetail.password) {
        this.userLogin.emit();
      }
    });
  }

}
