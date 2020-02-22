import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';


export interface User{
  user_id : number;
  user_name: string;
  user_password: number;
  user_firstname: string;
  user_last_name: string;
  user_email: string;
  user_role_id: number;
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
