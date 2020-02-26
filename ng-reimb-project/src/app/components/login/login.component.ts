import { Component, OnInit, ViewChild, Input, EventEmitter } from '@angular/core';
import {LoginService} from 'src/app/services/login.service'
import { NgForm } from '@angular/forms';
import {Router, CanActivate } from '@angular/router'


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  // template: ''
 
})


// class routerGuard implements CanActivate{
//   canActivate(){
//     return false;
//   }
// }

export class LoginComponent implements OnInit {
  testing = "duckling";
@ViewChild("f") loginForm:NgForm;
constructor(
  private loginService : LoginService,
  private router: Router) { }

loginInfo={
  username:'',
  userpassword:''
}

  ngOnInit(): void {
  }


  onSubmit(){
    this.loginInfo.username=this.loginForm.value.username;
    this.loginInfo.userpassword=this.loginForm.value.userpassword;
    this.loginService.loginVerification(this.loginInfo)
    this.router.navigate(['/home'])
    // this.loginService.userChanged.subscribe(
    //   (val)=>this.router.navigate(['/home']),
    //   (err)=>err
    // )

    
  }

}

 