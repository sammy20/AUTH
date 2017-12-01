import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient, HttpErrorResponse } from '@angular/common/http'
import { Router } from '@angular/router';

import { User } from '../../model/user';

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup = null;
  errorMessage: string = "";
  successMessage: string = "";

  constructor(
    private httpClient: HttpClient,
    private router: Router,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {
    this.buildForm();
  }

  buildForm(): void{
    this.registerForm = this.formBuilder.group({
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
    ],
    email: ["",[
        Validators.required,
        Validators.email
      ]
    ],
    role: ["",[
        Validators.required
      ]
    ]
    })
  }

  get username(){
    return this.registerForm.get("username");
  }

  get password(){
    return this.registerForm.get("password");
  }

  get email(){
    return this.registerForm.get("email");
  }

  get role(){
    return this.registerForm.get("role");
  }

  registerUser(): void{
    if(this.registerForm.valid){
      this.httpClient.post<User>("http://localhost:8080/api/users", this.registerForm.value).
      subscribe(
        data => {
          this.registerForm.reset();
          this.successMessage = "User created successfully";
          setTimeout(() => {
            this.router.navigate(["/login"]);
          }, 3000);
        },
        (err: HttpErrorResponse) => {
          if(err.error instanceof Error){
            this.errorMessage = "Cannot connect to the server";
          }
          else{
            this.errorMessage = "Username already exists";
            setTimeout(() => {
              this.errorMessage = "";
            }, 3000);
          }
        }
      );
    }
  }

}
