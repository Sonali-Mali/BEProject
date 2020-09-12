import { Component, OnInit } from '@angular/core';
import { SmartContractService } from './../smart-contract.service';

@Component({
  selector: 'app-builders',
  templateUrl: './builders.component.html',
  styleUrls: ['./builders.component.css']
})
export class BuildersComponent implements OnInit {

  public id = '';
  public publickey = '';
  public address = '';
  public contact = '';
  public name = '';
  public city = '';
  public message = '';

  constructor(public smartcontract: SmartContractService) { }

  ngOnInit(): void {
  }

  public addBuilder() {
    this.message = 'Adding builder...';
    this.smartcontract.addBuilder(this.id, this.publickey, this.address, this.contact, this.name, this.city);
    this.message = 'Builder added';
  }

}