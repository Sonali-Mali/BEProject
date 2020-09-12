import { Component, OnInit } from '@angular/core';
import { Wallet } from '../wallet';
import { SmartContractService } from './../smart-contract.service';

@Component({
  selector: 'app-choose-wallet',
  templateUrl: './choose-wallet.component.html',
  styleUrls: ['./choose-wallet.component.css']
})
export class ChooseWalletComponent implements OnInit {

  public publickey = '';
  public privatekey = '';

  constructor(private smartcontract : SmartContractService) { }

  ngOnInit() {
  }

  public onChooseWallet(event) {
    const reader = new FileReader();
    reader.onload = (result) => {
      const text: string = result.target['result'].toString();
      const tokens = text.split("\n");
      console.log(tokens);
      Wallet.PRIVATE_KEY = tokens[0];
      Wallet.PUBLIC_KEY = tokens[1];

      console.log(Wallet.PRIVATE_KEY);
      console.log(Wallet.PUBLIC_KEY);
    };

    reader.readAsText(event.target.files[0]);
  }

  public getAddress() {
    this.publickey = Wallet.PUBLIC_KEY;
    this.privatekey = Wallet.PRIVATE_KEY;
  }

}
