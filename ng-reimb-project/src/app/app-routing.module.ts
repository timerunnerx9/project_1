import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ReimbComponent } from './components/reimb/reimb.component';
import { LoginComponent } from './components/login/login.component';


const routes : Routes = [
  {component:LoginComponent, path:'login'},
  {component:HomeComponent, path:'home'},
  {component:ReimbComponent, path:'reimb'}
  
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
