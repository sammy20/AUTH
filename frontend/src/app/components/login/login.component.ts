import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient, HttpErrorResponse } from '@angular/common/http'
import { Router } from '@angular/router';

import { SessionService } from '../../services/session.service';

import { User } from '../../model/user';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup = null;
  errorMessage: string = "";

  constructor(
    private httpClient: HttpClient,
    private router: Router,
    private formBuilder: FormBuilder,
    private sessionService: SessionService
  ) { }

  ngOnInit() {
    this.buildForm();
  }

  buildForm(): void{
    this.loginForm = this.formBuilder.group({
      username: ["",[
        Validators.required,
        Validators.minLength(5),
        Validators.maxLength(30)
      ]
    ],
    password: ["",[
        Validators.required,
        Validators.minLength(5),
        Validators.maxLength(30)
      ]
    ]
    })
  }

  get username(){
    return this.loginForm.get("username");
  }

  get password(){
    return this.loginForm.get("password");
  }

  loginUser(): void{
    if(this.loginForm.valid){
      this.httpClient.post<User>("http://localhost:8080/api/users/login", this.loginForm.value).
      subscribe(
        data => {
          this.sessionService.login(data as User);
          // a redirect to /home now
        },
        (err: HttpErrorResponse) => {
          if(err.error instanceof Error){
            this.errorMessage = "Cannot connect to the server";
          }
          else{
            this.errorMessage = "Username or password are invalid";
            setTimeout(() => {
              this.errorMessage = "";
            }, 3000);
          }
        }
      );
    }
  }

  loginGuest(): void{
    this.router.navigate(["/home"]);
  }



}
