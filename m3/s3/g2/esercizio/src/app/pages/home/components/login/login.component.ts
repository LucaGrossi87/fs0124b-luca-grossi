import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  form!:FormGroup;

  constructor(private fb: FormBuilder){}

  un:string = ''
  pw:string = ''

  ngOnInit(){

    this.form = this.fb.group({
      username: this.fb.control(null,[Validators.required]),
      password: this.fb.control(null,[Validators.required]),
    })

  }

  adminPriv(){
    this.un = this.form.get('username')!.value;
    this.pw = this.form.get('password')!.value;
    console.log(this.un=='admin'&& this.pw=='admin');
    return this.un=='admin'&&this.pw=='admin'
  }

}
