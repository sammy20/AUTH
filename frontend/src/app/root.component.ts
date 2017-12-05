import { Component } from '@angular/core';

@Component({
  selector: 'root',
  template: `
    <div class="container-fluid root">
      <router-outlet></router-outlet>
    </div>  
  `,
  styles: [`
    .root{
      padding:0
    }
  `]
})
export class RootComponent {}
