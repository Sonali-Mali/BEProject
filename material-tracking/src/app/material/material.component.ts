import { Component, OnInit } from '@angular/core';
import { SmartContractService } from './../smart-contract.service';

@Component({
  selector: 'app-material',
  templateUrl: './material.component.html',
  styleUrls: ['./material.component.css']
})
export class MaterialComponent implements OnInit {

  constructor(private smartcontract : SmartContractService) { }

  ngOnInit(): void {
  }

}
