import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SpeciesFormComponent } from './species-form/species-form.component';
import { SpeciesListComponent } from './species-list/species-list.component';
import { SpecimenFormComponent } from './specimen-form/specimen-form.component';
import { SpecimenListComponent } from './specimen-list/specimen-list.component';

const routes: Routes = [
  {path: 'specimens', component: SpecimenListComponent},
  {path: 'addspecimen', component: SpecimenFormComponent},
  {path: 'species', component: SpeciesListComponent},
  {path: 'addspecies', component: SpeciesFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
