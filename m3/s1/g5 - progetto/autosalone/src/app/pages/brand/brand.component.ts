import { Component, OnInit } from '@angular/core';
import { iCar } from '../../models/i-car';
import { CarsService } from '../../cars.service';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-brand',
  templateUrl: './brand.component.html',
  styleUrl: './brand.component.scss'
})
export class BrandComponent implements OnInit {
  brand:string=''
  carsArr:iCar[] = [];
  noRepeatBrand: {brand: string, brandLogo: string}[] = [];
  details: iCar={
    brand: '',
    brandLogo: '',
    model: '',
    modelImage: '',
    year: 0,
    price: 0,
    available: false,
  }
  randomArr:iCar[]=[]

  brandArr:iCar[]=[]

  constructor(private carsSvc:CarsService, private route: ActivatedRoute){}

  ngOnInit(){

    this.carsSvc.getCars().then((res: iCar[]) => {

      this.carsArr = res;

      this.route.paramMap.subscribe(params => {
        this.brand = params.get('brand') || ''
      });

      for (let i = 0; i < this.carsArr.length; i++) {
        let el = this.carsArr[i];
        if (el.brand.toLowerCase()==this.brand){
          this.brandArr.push(el)
        }
        console.log(el);
      }
})}}
