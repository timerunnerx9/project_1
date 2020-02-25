import { Component, OnInit, Input } from '@angular/core';
import {UserService, User} from 'src/app/services/user.service';
import { Observable } from 'rxjs';
import {LoginService} from 'src/app/services/login.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],

})
export class HomeComponent implements OnInit {

      @Input() rs:string;
     
  

      user: User={
      user_id: 0,
      username: '',
      password: '',
      firstname: '',
      lastname: '',
      email: '',
      role_id: 0
    }
  


  
  constructor(
    private userService: UserService,
    private loginService: LoginService) { }

  ngOnInit(): void {
  }

  // this.loginService.loginVerification(this.loginInfo).subscribe((val)=>
  // {
  // this.user.id =val.user_id,
  // this.user.username=val.username,
  // this.user.password=val.password,
  // this.user.firstname=val.firstname,
  // this.user.lastname = val.lastname,
  // this.user.email=val.email,
  // this.user.role_id=val.role_id}
  // );


}
