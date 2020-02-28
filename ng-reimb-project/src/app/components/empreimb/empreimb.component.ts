import { Component, OnInit, ViewChild } from '@angular/core';
import { ReimbService } from 'src/app/services/reimb.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-empreimb',
  templateUrl: './empreimb.component.html',
  styleUrls: ['./empreimb.component.css']
})
export class EmpReimbComponent implements OnInit {
  @ViewChild('f2')
  reimbForm : NgForm;
  type:string;


  constructor(private reimbService:ReimbService) { }

  ngOnInit(): void {
   
  }


dropDownHandler (event:any){
  this.type=event.target.value;
}


onSubmit(){
  this.reimbForm.value.rei
}
}
