import { Injectable } from '@angular/core';
import { iCar } from './models/i-car';

@Injectable({
  providedIn: 'root'
})
export class CarsService {

  getCars():Promise<iCar[]>{

    return fetch('../assets/db.json')
    .then(res => res.json())
    .then((res:iCar[]) => res)

  }

  // getAvailableCar():Promise<iCar[]>{
  //   return this.getCars()
  //   .then(res => res.filter(p => p.available))
  // }

  // getUnavailableCar():Promise<iCar[]>{
  //   return this.getCars()
  //   .then(res => res.filter(p => !p.available))
  // }

  // getCarByModel(mod:string):Promise<iCar | undefined>{
  //   return this.getCars()
  //   .then(res => res.find(p => p.model == mod))
  // }


}

