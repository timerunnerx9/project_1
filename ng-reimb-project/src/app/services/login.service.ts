import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user.service';






@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient: HttpClient) { }




loginVerification(postdata :{userid:number, userpassword:string}): Observable<User> {
  const url = "http://localhost:8081/project_1/LoginServlet"
  return this.httpClient.post<User>(url,postdata,{
    headers: new HttpHeaders({
      'Content-Type':'application/json'
    })
  });


}

}
