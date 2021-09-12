import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Species } from '../model/species';
import { Specimen } from '../model/specimen';
import { ImageUploadService } from '../service/image-upload.service';
import { SpeciesService } from '../service/species.service';
import { SpecimenService } from '../service/specimen.service';

@Component({
  selector: 'app-specimen-form',
  templateUrl: './specimen-form.component.html',
  styleUrls: ['./specimen-form.component.css']
})
export class SpecimenFormComponent implements OnInit {

  public specimen: Specimen;
  public speciesList!: Species[];
  private apiServerUrl = environment.apiBaseUrl + "/file";

  selectedFile = null;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private specimenService: SpecimenService,
    private speciesService: SpeciesService,
    private imageUploadService: ImageUploadService,
    private http: HttpClient
  ) {
    this.specimen = new Specimen();
  }


  onSubmit() {
    this.uploadImage();
    this.specimenService.saveSpecimen(this.specimen).subscribe(result => {
      this.gotoSpecimenList();
    })
  }

  gotoSpecimenList() {
    this.router.navigate(['/specimens']);
  }

  onFileSelected(event: Event) {
    console.log(event);
    // @ts-ignore: Object is possibly 'null'.
    this.selectedFile = event.target.files[0];
    // @ts-ignore: Object is possibly 'null'.
    this.specimen.image.name = event.target.files[0].name;
  }

  uploadImage() {
    const id: number = parseInt(this.specimen.species.id);
    const index: number = this.speciesList.findIndex(i => parseInt(i.id) == id);
    const speciesName: string = this.speciesList[index].name;
    const specimenName: string = this.specimen.name;
    if (this.selectedFile != null) {
      this.specimen.setImagePath(speciesName);
      this.imageUploadService.uploadImage(this.selectedFile, speciesName, specimenName);
    }
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
