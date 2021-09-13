import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ImageUploadService {

  private apiServerUrl = environment.apiBaseUrl + "/file";

  constructor(private http: HttpClient) { }

  public uploadImage( selectedFile: null, speciesName: string, specimenName: string) {
    debugger;
    const formData = new FormData();
    if (selectedFile != null) {
      // @ts-ignore: Object is possibly 'null'.
      formData.append('file', selectedFile, selectedFile.name);
      formData.append('species', speciesName);
      formData.append('specimenName', specimenName);
      this.http.post(`${this.apiServerUrl}/upload`, formData, { headers: new HttpHeaders() })
        .subscribe(response => {
          console.log("Uploaded");
        })
    }
  }
}
