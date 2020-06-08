import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ChooseWalletComponent } from './choose-wallet/choose-wallet.component';
import { DeployContractComponent } from './deploy-contract/deploy-contract.component';
import { TransactComponent } from './transact/transact.component';

const routes: Routes = [
  {
    path: 'choose-wallet', component: ChooseWalletComponent
  },
  {
    path: 'deploy-contract', component: DeployContractComponent
  },
  {
    path: 'transact', component: TransactComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
