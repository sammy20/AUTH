import { Injectable } from '@angular/core';
import { User } from '../model/user'

@Injectable()
export class SessionService {

  private user: User = null;

  login(user: User): void{
    this.user = user;
    // redirect to home, dont let him acces login or registration if logged in
  }

  logout(){
    this.user = null;
    // redirect login, dont let him acces /home if not logged in
  }

  loggedUser(): User{
    return this.user;
  }

  isLogged(): boolean{
    return (this.user !== null);
  }

  isStudent(): boolean{
    if(!this.isLogged()){
      return false;
    }
    return (this.user.getRole() == "student");
  }

  isOrganization(): boolean{
    if(!this.isLogged()){
      return false;
    }
    return (this.user.getRole() == "organization");
  }

}
