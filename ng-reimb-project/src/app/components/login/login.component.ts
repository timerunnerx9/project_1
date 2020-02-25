import { Component, OnInit, ViewChild, Input } from '@angular/core';
import {LoginService} from 'src/app/services/login.service'
import { NgForm } from '@angular/forms';
import {Router, CanActivate } from '@angular/router'


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  // template: ``
 
})


// class routerGuard implements CanActivate{
//   canActivate(){
//     return false;
//   }
// }

export class LoginComponent implements OnInit {
@ViewChild("f") loginForm:NgForm;

testing = "duck u";

loginInfo={
  username:'',
  userpassword:''
}


user ={
   id: 0,
   username: '',
   password: '',
   firstname: '',
   lastname: '',
   email: '',
   role_id: 0
}


  constructor(
    private loginService : LoginService,
    private router: Router) { }



  ngOnInit(): void {
  }



  onSubmit(){
    this.loginInfo.username=this.loginForm.value.username;
    this.loginInfo.userpassword=this.loginForm.value.userpassword;
    this.loginService.loginVerification(this.loginInfo).subscribe((val)=>
    {
    this.user.id =val.user_id,
    this.user.username=val.username,
    this.user.password=val.password,
    this.user.firstname=val.firstname,
    this.user.lastname = val.lastname,
    this.user.email=val.email,
    this.user.role_id=val.role_id}
    );
    this.router.navigate(['/home']);
  }


}

 