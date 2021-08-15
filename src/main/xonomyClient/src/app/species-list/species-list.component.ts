import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Species } from '../model/species';
import { SpeciesService } from '../service/species.service';

@Component({
  selector: 'app-species-list',
  templateUrl: './species-list.component.html',
  styleUrls: ['./species-list.component.css']
})
export class SpeciesListComponent implements OnInit {

  public speciesList: Species[] | undefined;

  constructor(private speciesService: SpeciesService) { }

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
