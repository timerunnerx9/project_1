import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Observable, observable } from 'rxjs';




 interface Reimb{
    reimb_id: number,
    reimb_amount: number;
    reimb_submitted:string,
    reimb_resolved:string,
    reimb_description:string,
    reimb_receipt:string,
    reimb_author:number;
    reimb_resolver:number;
    reimb_status_id:number;
    reimb_type_id:number;
  
  
}

 const reimb ={
  reimb_id: 0,
  reimb_amount: 0,
  reimb_submitted:"",
  reimb_resolved:"",
  reimb_description:"",
  reimb_receipt:"",
  reimb_author:"",
  reimb_resolver:"",
  reimb_status_id:0,
  reimb_type_id:0

}

let reimbMap = new Map();






@Injectable({
  providedIn: 'root'
})
export class ReimbService {

  constructor(private httpClient:HttpClient) { }





  getReimbByUserid(){
    const url = "http://localhost:8081/project_1/ReimbServlet"
    let params = new HttpParams()
      .set("actionType","101")
      .set("observe", "response")

    this.httpClient.get<Reimb>(url,{params, observe:"response"}
      ).subscribe()
  }


  onCreateReimb(): Promise<string>{
    const url = "http://localhost:8081/project_1/ReimbServlet";
    return this.httpClient.post(url,'hi',{responseType:'text'}).toPromise();

  }



  
















}



