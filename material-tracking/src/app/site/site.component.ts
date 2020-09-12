import { Component, OnInit } from '@angular/core';
import { SmartContractService } from './../smart-contract.service';

@Component({
  selector: 'app-site',
  templateUrl: './site.component.html',
  styleUrls: ['./site.component.css']
})
export class SiteComponent implements OnInit {

  constructor(private smartcontract : SmartContractService) { }

  ngOnInit(): void {
  }

}
