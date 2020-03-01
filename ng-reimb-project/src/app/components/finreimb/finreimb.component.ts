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
    this.reimbService.getReimbByUserid();
    this.reimbService.reimbRecord$.subscribe(reimbrecords =>
      {
        console.log(reimbrecords);
        this.reimbrecords = reimbrecords;
        console.log(this.reimbrecords);
      });
  }

}
