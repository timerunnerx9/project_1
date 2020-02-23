import { Component, OnInit } from '@angular/core';
import { ReimbService } from 'src/app/services/reimb.service';

@Component({
  selector: 'app-reimb',
  templateUrl: './reimb.component.html',
  styleUrls: ['./reimb.component.css']
})
export class ReimbComponent implements OnInit {

reimb ={
  reimb_id:"",
  reimb_amount:""
  // reimb_submitted:"",
  // reimb_resolved:"",
  // reimb_description:"",
  // reimb_receipt:"",
  // reimb_author:"",
  // reimb_resolver:"",
  // reimb_status_id:"",
  // reimb_type_id:""

}


  constructor(private reimbService:ReimbService) { }

  ngOnInit(): void {
  }


  async test(){
    console.log((await this.reimbService.onCreateReimb()));
  }



}
