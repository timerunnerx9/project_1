import { Component, OnInit, ViewChild } from '@angular/core';
import { ReimbService } from 'src/app/services/reimb.service';
import { NgForm } from '@angular/forms';
import { Reimb } from 'src/app/services/reimb.service';


@Component({
  selector: 'app-empreimb',
  templateUrl: './empreimb.component.html',
  styleUrls: ['./empreimb.component.css']
})



export class EmpReimbComponent implements OnInit {
  @ViewChild('f2')
  reimbForm : NgForm;
  type:string;



  reimbrecords: Reimb[]= [];


  // private reimb:Reimb ={
  //   reimb_id: 0,
  //   reimb_amount: 0,
  //   reimb_submitted:"",
  //   reimb_resolved:"",
  //   reimb_description:"",
  //   reimb_receipt:"",
  //   reimb_author:0,
  //   reimb_resolver:0,
  //   reimb_status_id:0,
  //   reimb_type_id:0
  
  // }


  constructor(private reimbService:ReimbService) { }


  ngOnInit(): void {
    this.reimbService.getReimbByUserid();
    this.reimbService.reimbRecord$.subscribe(reimbrecords =>
      {
        console.log(reimbrecords);
        this.reimbrecords = reimbrecords;
       
      });
    
  }


dropDownHandler1 (event:any){
  this.type=event.target.value;
}

dropDownHandler2 (event:any){
  this.type=event.target.value;
}

onSubmit(){
  console.log("works");
}



}
