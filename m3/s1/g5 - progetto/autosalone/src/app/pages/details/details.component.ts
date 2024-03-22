import { Component, OnInit } from '@angular/core';
import { iCar } from '../../models/i-car';
import { CarsService } from '../../cars.service';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrl: './details.component.scss'
})
export class DetailsComponent implements OnInit {
  carsArr:iCar[]=[];
  carDetails:iCar | undefined

  constructor(private carsSvc:CarsService, private route: ActivatedRoute){}

  ngOnInit(){

    this.carsSvc.getCars().then(res => {

      this.carsArr = res;

      this.route.paramMap.subscribe(params => {
        const model = params.get('model');
        if (model) {
          this.carsSvc.getCars().then(cars => {
            this.carDetails = cars.find(car => car.model == model);
          });
        }
      })})}}
