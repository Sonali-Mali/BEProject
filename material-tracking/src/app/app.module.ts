import { HttpClient, HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ChooseWalletComponent } from './choose-wallet/choose-wallet.component';
import { AddAdminComponent } from './add-admin/add-admin.component';
import { FormsModule } from '@angular/forms';
import { BuildersComponent } from './builders/builders.component';
import { ManufacturerComponent } from './manufacturer/manufacturer.component';
import { MaterialComponent } from './material/material.component';
import { SiteComponent } from './site/site.component';
import { SellerComponent } from './seller/seller.component';

@NgModule({
  declarations: [
    AppComponent,
    ChooseWalletComponent,
    AddAdminComponent,
    BuildersComponent,
    ManufacturerComponent,
    MaterialComponent,
    SiteComponent,
    SellerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
