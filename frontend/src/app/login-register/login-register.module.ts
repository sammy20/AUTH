import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { LoginRegisterRoutingModule } from './login-register-routing.module';

import { LoginRegisterComponent } from './login-register.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ValidationErrorsComponent } from './validation-errors/validation-errors.component';

import { LoginGuard } from './login-guard.service';

@NgModule({
  declarations: [
    LoginRegisterComponent,
    LoginComponent,
    RegisterComponent,
    ValidationErrorsComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    LoginRegisterRoutingModule
  ],
  providers: [
    LoginGuard
  ]
})
export class LoginRegisterModule { }
