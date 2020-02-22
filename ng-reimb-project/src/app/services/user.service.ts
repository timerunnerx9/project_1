import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';


export interface User{
  user_id : string;
  username: string;
  password: string;
  firstname: string;
  lastname: string;
  email: string;
  role_id: string;
}





@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }


  getUser(): Promise<User>{
    const url = "http://localhost:8081/project_1/UserServlet";
    return this.httpClient.get<User>(url).toPromise();

  }
}
