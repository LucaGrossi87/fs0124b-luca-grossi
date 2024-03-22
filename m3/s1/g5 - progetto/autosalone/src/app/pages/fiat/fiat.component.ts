import { Component } from '@angular/core';
import { iCar } from '../../models/i-car';
import { CarsService } from '../../cars.service';

@Component({
  selector: 'app-fiat',
  templateUrl: './fiat.component.html',
  styleUrl: './fiat.component.scss'
})
export class FiatComponent {
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

  fiatArr:iCar[]=[]
  constructor(private carsSvc:CarsService){}

  ngOnInit(){

    this.carsSvc.getCars().then((res: iCar[]) => {

      this.carsArr = res;

      // console.log(this.carsArr);


      for (let i = 0; i < this.carsArr.length; i++) {
        let el = this.carsArr[i];
        if (el.brand=='Fiat'){
          this.fiatArr.push(el)
        }
      }

      // console.log(this.fiatArr);

    });
  }

}
