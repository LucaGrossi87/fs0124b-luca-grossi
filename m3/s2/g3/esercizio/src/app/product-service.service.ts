import { Injectable } from '@angular/core';
import { iProduct, iRoot } from './models/i-products';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  apiUrl:string = 'https://dummyjson.com/products';

  constructor(private http:HttpClient){}


  getAll(){
    return this.http.get<iRoot>(this.apiUrl)
  }

  favArrSvc:iProduct[]=[]
  cartArrSvc:iProduct[]=[]

}
