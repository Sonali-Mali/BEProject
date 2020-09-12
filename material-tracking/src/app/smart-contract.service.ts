import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SmartContractService {

  private BASE_URL = 'http://localhost:15481/service';
  private CONTACT_ADDRESS = '0xaa';

  public citylist;
  public builderlist;

  constructor(private http: HttpClient) {
    if (localStorage.citylist) {
      this.citylist = JSON.parse(localStorage.citylist);
    }
    else {
      this.citylist = localStorage.citylist = [];
    }
    if (localStorage.builderlist) {
      this.builderlist = JSON.parse(localStorage.builderlist);
    }
    else {
      this.builderlist = localStorage.builderlist = [];
    }
    // console.log(this.citylist);
  }

  public async postRequest(type: string, command: string, params: any[]) {
    const sign = '';
    const sender = '';
    return await this.http.post(this.BASE_URL, {
      type,
      command,
      params,
      sender,
      sign
    });
  }

  public async addAdmin(city: string, address: string) {
    this.citylist.push([city, address]);
    localStorage.setItem('citylist', JSON.stringify(this.citylist));
    return await this.postRequest('update', 'ADD_ADMIN', [city, address]);
  }

  public async addBuilder(id: string, publickey: string, address: string, contact: string, name: string, city: string) {
    this.builderlist.push([id, publickey, address, contact, name, city]);
    localStorage.setItem('builderlist', JSON.stringify(this.builderlist));
    return await this.postRequest('update', 'ADD_BUILDER', [id, publickey, address, contact, name, city]);
  }

}
