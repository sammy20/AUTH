import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { SessionService } from '../../services/session.service';

@Component({
  selector: 'navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(
    private router: Router,
    private sessionService: SessionService
  ) { }

  ngOnInit() {
  }

  logout(): void{
    this.sessionService.logout();
    this.router.navigate(['/login']);
  }

  isUser(): boolean{
    return this.sessionService.isUser();
  }

  isGuest(): boolean{
    return this.sessionService.isGuest();
  }

}
