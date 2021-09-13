import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SpecimenService } from './service/specimen.service';
import { SpecimenListComponent } from './specimen-list/specimen-list.component';
import { SpecimenFormComponent } from './specimen-form/specimen-form.component';
import { SpeciesFormComponent } from './species-form/species-form.component';
import { SpeciesListComponent } from './species-list/species-list.component';
import { SpeciesService } from './service/species.service';
import { SidebarComponent } from './sidebar/sidebar.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ImageUploadService } from './service/image-upload.service';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    SpecimenListComponent,
    SpecimenFormComponent,
    SpeciesFormComponent,
    SpeciesListComponent,
    SidebarComponent,
    NavbarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule
  ],
  providers: [SpecimenService, SpeciesService, ImageUploadService],
  bootstrap: [AppComponent]
})
export class AppModule { }
