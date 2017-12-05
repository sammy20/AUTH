import { Injectable } from '@angular/core';
import { User } from '../models/user'

@Injectable()
export class SessionService {

  private user: User = null;

  login(user: User): void{
    this.user = user;
  }

  logout(){
    this.user = null;
  }

  loggedUser(): User{
    return this.user;
  }

  isLogged(): boolean{
    return this.user !== null;
  }

  isUser(): boolean{
    return this.isLogged() && (this.isStudent() || this.isOrganization());
  }

  isGuest(): boolean{
    return this.isLogged() && (this.user.getRole() == "guest");
  }

  isStudent(): boolean{
    return this.isLogged() && (this.user.getRole() == "student");
  }

  isOrganization(): boolean{
    return this.isLogged() && (this.user.getRole() == "organization");
  }

}
