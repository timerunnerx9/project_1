import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';


export interface User{
  user_id : number;
  username: string;
  password: string;
  firstname: string;
  lastname: string;
  email: string;
  role_id: number;
}





@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }


  // getUser(): Promise<User>{
  //   const url = "http://localhost:8081/project_1/UserServlet";
  //   return this.httpClient.get<User>(url).toPromise();

  // }



  getUser(): void{
    const url = "http://localhost:8081/project_1/UserServlet";
    this.httpClient.get<User>(url).subscribe(val=>console.log(val));
                    

  }

}
