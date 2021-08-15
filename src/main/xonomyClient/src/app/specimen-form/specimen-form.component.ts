import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Species } from '../model/species';
import { Specimen } from '../model/specimen';
import { SpeciesService } from '../service/species.service';
import { SpecimenService } from '../service/specimen.service';

@Component({
  selector: 'app-specimen-form',
  templateUrl: './specimen-form.component.html',
  styleUrls: ['./specimen-form.component.css']
})
export class SpecimenFormComponent implements OnInit {

  public specimen : Specimen;
  public speciesList: Species[] | undefined;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private specimenService: SpecimenService,
    private speciesService: SpeciesService)
    {
      this.specimen = new Specimen();
    }


  onSubmit() {
    this.specimenService.saveSpecimen(this.specimen).subscribe(result => {
      this.gotoSpecimenList();
    })
  }

  gotoSpecimenList() {
    this.router.navigate(['/specimens']);
  }

  ngOnInit(): void {
    this.speciesService.getSpecies().subscribe(response => {
      this.speciesList = response;
      console.log(this.speciesList);
    }),
    (error: HttpErrorResponse) => {
      alert(error.message)
    }
  }

}
