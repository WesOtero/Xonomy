import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SpecimenService } from './service/specimen.service';
import { SpecimenListComponent } from './specimen-list/specimen-list.component';

@NgModule({
  declarations: [
    AppComponent,
    SpecimenListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [SpecimenService],
  bootstrap: [AppComponent]
})
export class AppModule { }
