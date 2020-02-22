import { Component, OnInit } from '@angular/core';
import {UserService, User} from 'src/app/services/user.service';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  user = {
    id:'',
    username: '',
    password: '',
    firstname: '',
    lastname: '',
    email: '',
    role_id: ''
  }
  
  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }


  async click(){
    const result: User = await this.userService
    .getUser();

    this.user.id =  result.user_id,
    this.user.username =  result.username,
    this.user.password = result.password,
    this.user.firstname =  result.firstname,
    this.user.lastname = result.lastname,
    this.user.email = result.email,
    this.user.role_id = result.role_id;
    
  }
}
