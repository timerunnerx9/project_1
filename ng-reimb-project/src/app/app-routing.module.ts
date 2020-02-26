import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ReimbComponent } from './components/reimb/reimb.component';
import { LoginComponent } from './components/login/login.component';
import { ContentComponent } from './components/content/content.component';


const routes : Routes = [
  {component:LoginComponent, path:'login'},
  {component:HomeComponent, path:'home'},
  {component:ReimbComponent, path:'reimb'},
  {component:ContentComponent, path:'content'},
  {component:HomeComponent, path: '**'}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
