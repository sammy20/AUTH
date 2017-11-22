import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
 
import { MainComponent } from './main/main.component'
import { PageOneComponent }   from './page-one/page-one.component';
import { PageTwoComponent }      from './page-two/page-two.component';
import { AppComponent }  from './app.component';
 
const routes: Routes = [
  { path: '', component: MainComponent },
  { path: 'one', component: PageOneComponent },
  { path: 'two', component: PageTwoComponent }
];
 
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}