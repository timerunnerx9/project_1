import { Component, OnInit } from '@angular/core';
import {LoginService, LoginInfo} from 'src/app/services/login.service'


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService : LoginService) { }

  ngOnInit(): void {
  }



  



}
