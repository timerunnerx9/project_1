import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ContentComponent } from './components/content/content.component';
import { EmpReimbComponent } from './components/empreimb/empreimb.component';
import { FinreimbComponent } from './components/finreimb/finreimb.component';
import { Fin2reimbComponent } from './components/fin2reimb/fin2reimb.component';

const routes : Routes = [
  {component:LoginComponent, path:'login'},
  {component:HomeComponent, path:'home'},
  {component:EmpReimbComponent, path:'empreimb'},
  {component:ContentComponent, path:'content'},
  {component:FinreimbComponent, path: 'finreimb'},
  {component:Fin2reimbComponent, path: 'fin2reimb'},
  {component:HomeComponent, path: '**'}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
