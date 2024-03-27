import { Component } from '@angular/core';
import { iProduct, iRoot } from '../../models/i-products';
import { ProductServiceService } from '../../product-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {


  constructor(private prodSvc:ProductServiceService){}

  prods:iRoot={
    products: [],
    total: 0,
    skip: 0,
    limit: 0
  }
  prodsArr:iProduct[]=[]

  favArr:iProduct[]=this.prodSvc.favArrSvc

  cartArr:iProduct[]=[]

  checkout:number = 0

  ngOnInit(){
    this.cartArr=this.prodSvc.cartArrSvc
    this.prodSvc.getAll().subscribe(prod => {
      this.prods = prod
      this.prodsArr=this.prods.products
      console.log(this.prodsArr);
    })
    for (let i = 0; i < this.prodSvc.cartArrSvc.length; i++) {
      this.checkout+=this.cartArr[i].price
    }
  }

  addFav(favId:number){
    let favorite = this.prodsArr.filter((favItem)=>{
      return favItem.id==favId
    })
    this.favArr.push(favorite[0])
    console.log( this.favArr);
    this.prodSvc.favArrSvc=this.favArr
  }

  addToCart(){
    for (let j = 0; j < this.prodSvc.favArrSvc.length; j++) {
      this.cartArr.push(this.prodSvc.favArrSvc[j])
    }
    this.prodSvc.cartArrSvc=this.cartArr
    this.favArr=[]
    this.prodSvc.favArrSvc=[]
    for (let i = 0; i < this.prodSvc.cartArrSvc.length; i++) {
      this.checkout+=this.cartArr[i].price
    }
  }


}
