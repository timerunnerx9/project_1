import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { User } from './user.service';






@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient: HttpClient) { }


//   user ={
//     id: 0,
//     username: '',
//     password: '',
//     firstname: '',
//     lastname: '',
//     email: '',
//     role_id: 0
//  }

//  private userSubject :Subject<string> = new Subject();
// public user$ = this.userSubject.asObservable();
//  this.user.id =  result.user_id,
//  this.user.username =  result.username,
//  this.user.password = result.password,
//  this.user.firstname =  result.firstname,
//  this.user.lastname = result.lastname,
//  this.user.email = result.email,
//  this.user.role_id = result.role_id;


loginVerification(postdata :{username:string, userpassword:string}): Observable<User> {
  const url = "http://localhost:8081/project_1/LoginServlet"
  return this.httpClient.post<User>(url,postdata,{
    headers: new HttpHeaders({
      'Content-Type':'application/json'
      // 'Content-Type':'text'
    })
  })

  }
}

