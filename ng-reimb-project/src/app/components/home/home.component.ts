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

  user: User;


    private userChangedSub: Subscription;


  constructor(
    private loginService: LoginService) { }

  ngOnInit(): void {

   
    this.user = this.loginService.getUser();
  
    
  }

}