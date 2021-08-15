import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Specimen } from '../model/specimen';

@Injectable({
  providedIn: 'root'
})
export class SpecimenService {
  
  private apiServerUrl = environment.apiBaseUrl + "/specimen";

  constructor(private http: HttpClient) {}

  public getSpecimens(): Observable<Specimen[]> {
    return this.http.get<Specimen[]>(`${this.apiServerUrl}/all`);
  }

  public saveSpecimen(specimen: Specimen) {
    return this.http.post<Specimen>(`${this.apiServerUrl}/add`, specimen);
  } 
}
