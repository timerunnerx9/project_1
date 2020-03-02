import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service'
@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

display:boolean;
  constructor(public loginService : LoginService) { }

  role:string;
  ngOnInit(): void {
    this.role = this.loginService.localStorage.getItem("role");

  }

}
