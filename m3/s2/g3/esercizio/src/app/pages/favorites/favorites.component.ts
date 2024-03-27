import { Component } from '@angular/core';
import { iProduct } from '../../models/i-products';
import { ProductServiceService } from '../../product-service.service';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrl: './favorites.component.scss'
})
export class FavoritesComponent {

  constructor(private prodSvc: ProductServiceService){}

  favArrPage:iProduct[]=this.prodSvc.favArrSvc

}
