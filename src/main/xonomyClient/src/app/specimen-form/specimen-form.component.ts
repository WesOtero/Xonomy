import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Specimen } from '../model/specimen';
import { SpecimenService } from '../service/specimen.service';

@Component({
  selector: 'app-specimen-form',
  templateUrl: './specimen-form.component.html',
  styleUrls: ['./specimen-form.component.css']
})
export class SpecimenFormComponent implements OnInit {

  public specimen : Specimen;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private specimenService: SpecimenService) {
    
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
    
  }

}
