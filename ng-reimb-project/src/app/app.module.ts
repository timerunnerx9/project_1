import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContentComponent } from './components/content/content.component';
import { UserComponent } from './components/user/user.component';
import { ReimbComponent } from './components/reimb/reimb.component';
import {HttpClientModule} from '@angular/common/http';
import {UserService} from './services/user.service';
import {ReimbService} from './services/reimb.service';
import {LoginComponent } from './components/login/login.component';
import {LoginService} from './services/login.service';

@NgModule({
  declarations: [
    AppComponent,
    ContentComponent,
    UserComponent,
    ReimbComponent,
    LoginComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [UserService, ReimbService, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
