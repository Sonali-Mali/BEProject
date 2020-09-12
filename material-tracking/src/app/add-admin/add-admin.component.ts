import { SmartContractService } from './../smart-contract.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-admin',
  templateUrl: './add-admin.component.html',
  styleUrls: ['./add-admin.component.css']
})
export class AddAdminComponent implements OnInit {

  public cname = '';
  public address = '';
  public message = '';

  constructor(public smartcontract: SmartContractService) { }

  ngOnInit(): void {
  }

  public addAdmin() {
    this.message = 'Adding admin...';
    this.smartcontract.addAdmin(this.cname, this.address);
    this.message = 'Admin added';
  }

}
