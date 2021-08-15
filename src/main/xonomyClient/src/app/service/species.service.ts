import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Species } from '../model/species';

@Injectable({
  providedIn: 'root'
})
export class SpeciesService {

  private apiServerUrl = environment.apiBaseUrl + "/species"

  constructor(private http: HttpClient) { }

  public getSpecies(): Observable<Species[]> {
    return this.http.get<Species[]>(`${this.apiServerUrl}/all`);
  }

  public saveSpecies(species: Species) {
    return this.http.post<Species>(`${this.apiServerUrl}/add`, species);
  }
}
