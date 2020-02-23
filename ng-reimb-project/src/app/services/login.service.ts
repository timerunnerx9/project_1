import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';




export interface LoginInfo{
  user_id: number;
  user_password: string;
}






@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient: HttpClient) { }




loginVerification(logininfo:LoginInfo): Observable<LoginInfo> {
  const url = "http://localhost:8081/project_1/LoginServlet"
  return this.httpClient.post<LoginInfo>(url,logininfo)
}



}
