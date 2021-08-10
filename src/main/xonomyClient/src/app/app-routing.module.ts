import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SpecimenFormComponent } from './specimen-form/specimen-form.component';
import { SpecimenListComponent } from './specimen-list/specimen-list.component';

const routes: Routes = [
  {path: 'specimens', component: SpecimenListComponent},
  {path: 'addspecimen', component: SpecimenFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
