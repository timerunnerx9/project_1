import { Component, OnInit, ViewChild } from '@angular/core';
import { ReimbService } from 'src/app/services/reimb.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-reimb',
  templateUrl: './reimb.component.html',
  styleUrls: ['./reimb.component.css']
})
export class ReimbComponent implements OnInit {
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
