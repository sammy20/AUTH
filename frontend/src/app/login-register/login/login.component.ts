import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient, HttpErrorResponse } from '@angular/common/http'
import { Router } from '@angular/router';

import { SessionService } from '../../services/session.service';

import { User } from '../../models/user';

@Component({
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

  login(): void{
    if(this.loginForm.valid){
      this.httpClient.post<any>("http://localhost:8080/login", this.loginForm.value).
      subscribe(
        data => {
          let user = new User();
          user.setId(data.id);
          user.setUsername(data.username);
          user.setPassword(data.password);
          user.setRole(data.role);
          user.setEmail(data.email);
          this.sessionService.login(user);
          this.router.navigate(["/home"]);
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
    let guest = new User();
    guest.setUsername("Guest");
    guest.setRole("guest");
    this.sessionService.login(guest);
    this.router.navigate(["/home"]);
  }

  logout(): void{
    this.sessionService.logout();
  }

  getUsername(): string{
    return this.sessionService.loggedUser().getUsername();
  }

  isUser(): boolean{
    return this.sessionService.isUser();
  }

}
