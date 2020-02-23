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
@NgModule({
  declarations: [
    AppComponent,
    ContentComponent,
    UserComponent,
    ReimbComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [UserService, ReimbService],
  bootstrap: [AppComponent]
})
export class AppModule { }
