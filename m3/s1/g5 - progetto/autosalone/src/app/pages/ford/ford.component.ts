import { Component } from '@angular/core';
import { iCar } from '../../models/i-car';
import { CarsService } from '../../cars.service';

@Component({
  selector: 'app-ford',
  templateUrl: './ford.component.html',
  styleUrl: './ford.component.scss'
})
export class FordComponent {
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

  fordArr:iCar[]=[]
  constructor(private carsSvc:CarsService){}

  ngOnInit(){

    this.carsSvc.getCars().then((res: iCar[]) => {

      this.carsArr = res;

      // console.log(this.carsArr);


      for (let i = 0; i < this.carsArr.length; i++) {
        let el = this.carsArr[i];
        if (el.brand=='Ford'){
          this.fordArr.push(el)
        }
      }

      // console.log(this.fordArr);

    });
}}
