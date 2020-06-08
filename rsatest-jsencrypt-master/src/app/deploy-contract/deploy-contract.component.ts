import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SmartContractContext } from '../smart-contract-context';
import { Wallet } from '../wallet';

@Component({
  selector: 'app-deploy-contract',
  templateUrl: './deploy-contract.component.html',
  styleUrls: ['./deploy-contract.component.css']
})
export class DeployContractComponent implements OnInit {

  public address:any = '';
  public classname = 'dapp.contracts.TestContract';

  constructor(private http: HttpClient, private wallet: Wallet) { }

  ngOnInit() {
  }

  public onDeploy() {
    this.http.post(SmartContractContext.BASE_URL, {
      type: 'create',
      sender: this.wallet.PUBLIC_KEY,
      params: [this.classname]
    }).subscribe((response) => {
      console.log(response);
      this.address = response;
    });
  }

}
