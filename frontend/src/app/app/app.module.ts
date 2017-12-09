import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { HomeComponent } from './home/home.component';
import { FavoritesComponent } from './favorites/favorites.component';

import { AppGuard } from './app-guard.service';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    HomeComponent,
    FavoritesComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule
  ],
  providers: [
    AppGuard
  ]
})
export class AppModule {}