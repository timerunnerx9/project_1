import { Component, OnInit } from '@angular/core';
import { ReimbService, Reimb } from 'src/app/services/reimb.service';

@Component({
  selector: 'app-finreimb',
  templateUrl: './finreimb.component.html',
  styleUrls: ['./finreimb.component.css']
})
export class FinreimbComponent implements OnInit {


  reimbrecords: Reimb[]= [];

  
  constructor(private reimbService:ReimbService) { }

  ngOnInit(): void {
    this.reimbService.getAllReimb();
    this.reimbService.reimbRecord$.subscribe(reimbrecords =>
      {
        this.reimbrecords = reimbrecords;
      });
  }

toggle(id) {
  var element = document.getElementById(id);
  element.style.display = element.style.display === 'block' ? 'none' : 'block';
}


  onApprove(reimb_id:string):void{
    this.reimbService.approveReimb(reimb_id);
  }

  onReject(reimb_id:string):void{
    this.reimbService.rejectReimb(reimb_id);
  }

}