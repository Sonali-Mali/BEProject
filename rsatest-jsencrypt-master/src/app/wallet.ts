import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class Wallet {
  public PUBLIC_KEY: string = null;
  public PRIVATE_KEY: string = null;
}
