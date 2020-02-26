import { Component, OnInit, Input } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import {LoginService} from 'src/app/services/login.service';
import { User } from 'src/app/services/user.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],

})
export class HomeComponent implements OnInit {

  user: User=
  {
    user_id: 0,
    username: '',
    password: '',
    firstname:'',
    lastname:'',
    email:"",
    role_id:0
  }

    private userChangedSub: Subscription;


  constructor(
    private loginService: LoginService) { }

  ngOnInit(): void {
    this.userChangedSub = this.loginService.userChanged
    .subscribe(
      (newuser:User)=>{
        // this.user = newuser);
        this.user.user_id =newuser.user_id,
        this.user.username=newuser.username,
        this.user.password=newuser.password,
        this.user.firstname=newuser.firstname,
        this.user.lastname = newuser.lastname,
        this.user.email=newuser.email,
        this.user.role_id=newuser.role_id}

    );
   
   // console.log(this.user.username);
    
  // console.log(this.user);
  // }
}
}