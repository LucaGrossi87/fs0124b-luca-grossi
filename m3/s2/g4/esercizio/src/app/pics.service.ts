import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { iPics, iRoot } from './models/i-pics';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PicsService {

  apiUrl:string = 'https://jsonplaceholder.typicode.com/photos';

  picsArray:iPics[] = []

  picsSubject = new BehaviorSubject<iPics[]>([]);

  $pics = this.picsSubject.asObservable()

  constructor(private http:HttpClient){
    this.getAll().subscribe(data => {
      this.picsSubject.next(data)
      this.picsArray = data;
    })
  }

  getAll(){
    return this.http.get<iRoot>(this.apiUrl)
  }

  // getById(id:number){
  //   return this.http.get<iPics>(this.apiUrl+'/'+id)
  // }

  // create(newPizza:iPics){
  //   return this.http.post<iPics>(this.apiUrl,newPizza)
  // }

  delete(id:number){
    return this.http.delete<iPics>(this.apiUrl+'/'+id)
  }

  // edit(pizza:iPics){
  //   return this.http.put<iPics>(this.apiUrl+'/'+pizza.id,pizza)
  // }

}
