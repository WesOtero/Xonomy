import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Specimen } from '../model/specimen';
import { SpecimenService } from '../service/specimen.service';

@Component({
  selector: 'app-specimen-list',
  templateUrl: './specimen-list.component.html',
  styleUrls: ['./specimen-list.component.css']
})
export class SpecimenListComponent implements OnInit {

  public specimens: Specimen[] | undefined;

  constructor(private specimenService: SpecimenService) { }

  ngOnInit(): void {
    this.specimenService.getSpecimens().subscribe(response => {
      this.specimens = response;
      console.log(this.specimens)
    }),
    (error: HttpErrorResponse) => {
      alert(error.message)
    }
  }

}
