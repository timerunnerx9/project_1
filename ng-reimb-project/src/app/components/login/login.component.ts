import { Component, OnInit, ViewChild } from '@angular/core';
import {LoginService} from 'src/app/services/login.service'
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
@ViewChild("f") loginForm:NgForm;

loginInfo = {
  username: '',
  userpassword: ''
};


  constructor(private loginService : LoginService) { }

  ngOnInit(): void {
  }


 

  onSubmit(){
    this.loginInfo.username=this.loginForm.value.username;
    this.loginInfo.userpassword=this.loginForm.value.userpassword;
    this.loginService.loginVerification(this.loginInfo).subscribe(()=>console.log());
  }



}
