import { Component, OnInit, ViewChild, Input, EventEmitter } from '@angular/core';
import {LoginService} from 'src/app/services/login.service'
import { NgForm } from '@angular/forms';
import {Router, CanActivate } from '@angular/router'



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})


// class routerGuard implements CanActivate{
//   canActivate(){
//     return false;
//   }
// }

export class LoginComponent implements OnInit {
 
@ViewChild("f1") loginForm:NgForm;

constructor(
  private loginService : LoginService,
  private router: Router,
  ) { }





  ngOnInit(): void {
    if(this.loginService.localStorage.getItem('user')){
      this.router.navigate(['/home'])
    }
  }



  onSubmit(){
    this.loginService.loginVerification(this.loginForm.value.username, 
      this.loginForm.value.userpassword);
    this.router.navigate(['/home'])
    
  }

}

 