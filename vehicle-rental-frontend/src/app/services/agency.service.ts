import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Agence {
  id?: number;
  nom: string;
  adresse: string;
  ville: string;
  telephone: string;
}

@Injectable({
  providedIn: 'root'
})
export class AgencyService {
  private apiUrl = 'http://localhost:8080/api/agences';

  constructor(private http: HttpClient) {}

  getAllAgencies(): Observable<Agence[]> {
    return this.http.get<Agence[]>(this.apiUrl);
  }

  getAgencyById(id: number): Observable<Agence> {
    return this.http.get<Agence>(`${this.apiUrl}/${id}`);
  }

  getAgencyByName(name: string): Observable<Agence> {
    return this.http.get<Agence>(`${this.apiUrl}/nom/${name}`);
  }

  createAgency(agency: Agence): Observable<Agence> {
    return this.http.post<Agence>(this.apiUrl, agency);
  }

  updateAgency(id: number, agency: Agence): Observable<Agence> {
    return this.http.put<Agence>(`${this.apiUrl}/${id}`, agency);
  }

  deleteAgency(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
