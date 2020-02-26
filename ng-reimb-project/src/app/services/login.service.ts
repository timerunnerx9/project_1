import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { User } from './user.service';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  userChanged = new Subject<User>();

  private user:User ={
    user_id: 0,
    username: '',
    password: '',
    firstname:'',
    lastname:'',
    email:"",
    role_id:0
  }

  

  constructor(private httpClient: HttpClient) { 

  }


getUser(){
  return this.user;
}



loginVerification(postdata :{username:string, userpassword:string}): void {
  const url = "http://localhost:8081/project_1/LoginServlet"
   this.httpClient.post<User>(url,postdata,{
    headers: new HttpHeaders({
      'Content-Type':'application/json'
    })
  }).subscribe((val)=>
  {
    this.user.user_id =val.user_id,
    this.user.username=val.username,
    this.user.password=val.password,
    this.user.firstname=val.firstname,
    this.user.lastname = val.lastname,
    this.user.email=val.email,
    this.user.role_id=val.role_id}
  )
  
    this.userChanged.next(this.user);
    console.log(this.user);

  }


}

