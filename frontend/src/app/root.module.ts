import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppModule } from './app/app.module';
import { LoginRegisterModule } from './login-register/login-register.module';
import { RootRoutingModule } from './root-routing.module';

import { RootComponent } from './root.component';

import { SessionService } from './services/session.service';

@NgModule({
  declarations: [
    RootComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppModule,
    LoginRegisterModule,
    RootRoutingModule
  ],
  providers: [
    SessionService
  ],
  bootstrap: [RootComponent]
})
export class RootModule {}
