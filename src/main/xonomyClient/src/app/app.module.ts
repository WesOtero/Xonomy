import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SpecimenService } from './service/specimen.service';
import { SpecimenListComponent } from './specimen-list/specimen-list.component';
import { SpecimenFormComponent } from './specimen-form/specimen-form.component';

@NgModule({
  declarations: [
    AppComponent,
    SpecimenListComponent,
    SpecimenFormComponent,
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
