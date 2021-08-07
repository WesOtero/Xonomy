import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SpecimenListComponent } from './specimen-list/specimen-list.component';

const routes: Routes = [
  {path: 'specimens', component: SpecimenListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
