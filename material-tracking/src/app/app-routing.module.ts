import { MaterialComponent } from './material/material.component';
import { SiteComponent } from './site/site.component';
import { SellerComponent } from './seller/seller.component';
import { ManufacturerComponent } from './manufacturer/manufacturer.component';
import { BuildersComponent } from './builders/builders.component';
import { AddAdminComponent } from './add-admin/add-admin.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ChooseWalletComponent } from './choose-wallet/choose-wallet.component';


const routes: Routes = [
  { path: 'choose-wallet', component: ChooseWalletComponent },
  { path: 'add-admin', component: AddAdminComponent },
  { path: 'builders', component: BuildersComponent },
  { path: 'manufacturer', component: ManufacturerComponent },
  { path: 'seller', component: SellerComponent },
  { path: 'site', component: SiteComponent },
  { path: 'material', component: MaterialComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
