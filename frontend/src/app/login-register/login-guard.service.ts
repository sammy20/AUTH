import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';

import { SessionService } from '../services/session.service';

@Injectable()
export class LoginGuard implements CanActivate {

    constructor(
        private router: Router,
        private sessionService: SessionService
    ){}

    canActivate(): boolean{
        if(this.sessionService.isUser()){
            this.router.navigate(['/login']);
            return false;
        }
        return true;
    }
}