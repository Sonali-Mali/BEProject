import { Component, OnInit } from '@angular/core';
import { SmartContractService } from './../smart-contract.service';

@Component({
  selector: 'app-seller',
  templateUrl: './seller.component.html',
  styleUrls: ['./seller.component.css']
})
export class SellerComponent implements OnInit {

  constructor(private smartcontract : SmartContractService) { }

  ngOnInit(): void {
  }

}
