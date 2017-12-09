import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { FavoritesComponent } from './favorites/favorites.component';

import { AppGuard } from './app-guard.service';
 
const routes: Routes = [ 
    {
      path: '',
      component: AppComponent,
      canActivate: [AppGuard],
      children: [
        {
          path: 'home',
          component: HomeComponent
        },
        {
          path: 'favorites',
          component: FavoritesComponent
        },
        {
          path: '',
          redirectTo: '/home',
          pathMatch: 'full'
        }
      ]
    }
];
 
@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}