import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';




export interface Reimb{
    reimb_id: string,
    reimb_amount: string
    // reimb_submitted:string,
    // reimb_resolved:string,
    // reimb_description:string,
    // reimb_receipt:string,
    // reimb_author:string,
    // reimb_resolver:string,
    // reimb_status_id:string,
    // reimb_type_id:string
  
  
}





@Injectable({
  providedIn: 'root'
})
export class ReimbService {

  constructor(private httpClient:HttpClient) { }





  onCreateReimb(): Promise<string>{
    const url = "http://localhost:8081/project_1/ReimbServlet";
    return this.httpClient.post(url,'hi',{responseType:'text'}).toPromise();

  }



  
















}



