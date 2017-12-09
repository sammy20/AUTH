import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';

import { SessionService } from '../services/session.service';

@Injectable()
export class AppGuard implements CanActivate {

    constructor(
        private router: Router,
        private sessionService: SessionService
    ){}

    canActivate(): boolean{
        if(!this.sessionService.isLogged()){
            this.router.navigate(['/login']);
            return false;
        }
        return true;
    }
}