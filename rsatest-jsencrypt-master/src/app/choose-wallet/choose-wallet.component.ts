import { Component, OnInit } from '@angular/core';
import { Wallet } from '../wallet';

@Component({
  selector: 'app-choose-wallet',
  templateUrl: './choose-wallet.component.html',
  styleUrls: ['./choose-wallet.component.css']
})
export class ChooseWalletComponent implements OnInit {

  public publickey;

  constructor(private wallet: Wallet) { }

  ngOnInit() {
  }

  public onFileChange(event) {
    console.log(event.target.files[0]);

    const fr = new FileReader();
    fr.onload = (result) => {
      const text: string =result.target['result'].toString();
      const tokens = text.split('\r\n');
      console.log(tokens);
      this.wallet.PRIVATE_KEY = result[0];
      this.publickey = this.wallet.PUBLIC_KEY = result[1];
    };
    fr.readAsText(event.target.files[0]);
  }

  
}
