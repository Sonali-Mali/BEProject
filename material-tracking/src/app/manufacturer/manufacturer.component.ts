import { Component, OnInit } from '@angular/core';
import { SmartContractService } from './../smart-contract.service';

@Component({
  selector: 'app-manufacturer',
  templateUrl: './manufacturer.component.html',
  styleUrls: ['./manufacturer.component.css']
})
export class ManufacturerComponent implements OnInit {

  constructor(private smartcontract : SmartContractService) { }

  ngOnInit(): void {
  }

}
