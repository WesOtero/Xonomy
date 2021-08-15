import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Species } from '../model/species';
import { SpeciesService } from '../service/species.service';

@Component({
  selector: 'app-species-form',
  templateUrl: './species-form.component.html',
  styleUrls: ['./species-form.component.css']
})
export class SpeciesFormComponent implements OnInit {

  public species: Species;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private speciesService: SpeciesService
    ) { 
      this.species = new Species();
    }
  
  onSubmit() {
    this.speciesService.saveSpecies(this.species).subscribe(result => {
      this.gotoSpeciesList();
    })
  }

  gotoSpeciesList() {
    this.router.navigate(['/species']);
  }

  ngOnInit(): void {
  }

}
