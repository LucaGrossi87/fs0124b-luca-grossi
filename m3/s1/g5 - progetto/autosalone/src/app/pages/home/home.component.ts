import { Component } from '@angular/core';
import { iCar } from '../../models/i-car';
import { CarsService } from '../../cars.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
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
  avaArr:iCar[]=[]

  constructor(private carsSvc:CarsService){}

  ngOnInit(){

    this.carsSvc.getCars().then(res => {

      this.carsArr = res;

      this.noRepeatBrand = this.getBrands(this.carsArr);

      this.randomize()
    });
  }

  getBrands(cars: iCar[]): { brand: string, brandLogo: string }[] {
    let brands: { brand: string, brandLogo: string }[] = [];
    let showBrand: Set<string> = new Set();
    cars.forEach(car => {
      if (!showBrand.has(car.brand)) {
        brands.push({ brand: car.brand, brandLogo: car.brandLogo });
        showBrand.add(car.brand);
      }
    });

    return brands;
    }

    randomize() {
      for (let j = 0; j < this.carsArr.length; j++) {
        const car = this.carsArr[j];
        if (car.available) {
          this.avaArr.push(car)
        }

      }
      for (let i = 0; i < 2; i++) {
        let randomNum: number = Math.floor(Math.random() * this.avaArr.length);
        let deleteCar = this.avaArr.splice(randomNum,1)

        this.details = deleteCar[0]

          this.randomArr.push({
            ...this.details,
      })
        }

      }
    }
