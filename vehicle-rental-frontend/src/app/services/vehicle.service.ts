import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Vehicule {
  id?: number;
  marque: string;
  modele: string;
  matricule: string;
  prixParJour: number;
  dateMiseEnService: string;
  statut: string;
  agenceId: number;
  agenceNom?: string;
  type?: string;
}

export interface Voiture extends Vehicule {
  nombrePortes: number;
  typeCarburant: string;
  boiteVitesse: string;
}

export interface Moto extends Vehicule {
  cylindree: number;
  typeMoto: string;
  casqueInclus: boolean;
}

@Injectable({
  providedIn: 'root'
})
export class VehicleService {
  private apiUrl = 'http://localhost:8080/api/vehicules';

  constructor(private http: HttpClient) {}

  getAllVehicles(): Observable<Vehicule[]> {
    return this.http.get<Vehicule[]>(this.apiUrl);
  }

  getVehicleById(id: number): Observable<Vehicule> {
    return this.http.get<Vehicule>(`${this.apiUrl}/${id}`);
  }

  getVehiclesByStatut(statut: string): Observable<Vehicule[]> {
    return this.http.get<Vehicule[]>(`${this.apiUrl}/statut/${statut}`);
  }

  getVehiclesByAgence(agenceId: number): Observable<Vehicule[]> {
    return this.http.get<Vehicule[]>(`${this.apiUrl}/agence/${agenceId}`);
  }

  getVehiclesByMarque(marque: string): Observable<Vehicule[]> {
    return this.http.get<Vehicule[]>(`${this.apiUrl}/marque/${marque}`);
  }

  createVehicle(vehicle: Vehicule): Observable<Vehicule> {
    return this.http.post<Vehicule>(this.apiUrl, vehicle);
  }

  updateVehicle(id: number, vehicle: Vehicule): Observable<Vehicule> {
    return this.http.put<Vehicule>(`${this.apiUrl}/${id}`, vehicle);
  }

  deleteVehicle(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
