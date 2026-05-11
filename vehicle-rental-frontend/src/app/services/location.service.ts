import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Location {
  id?: number;
  dateDebut: string;
  dateFin: string;
  prixTotal: number;
  vehiculeId: number;
}

@Injectable({
  providedIn: 'root'
})
export class LocationService {
  private apiUrl = 'http://localhost:8080/api/locations';

  constructor(private http: HttpClient) {}

  getAllLocations(): Observable<Location[]> {
    return this.http.get<Location[]>(this.apiUrl);
  }

  getLocationById(id: number): Observable<Location> {
    return this.http.get<Location>(`${this.apiUrl}/${id}`);
  }

  getLocationsByVehicle(vehicleId: number): Observable<Location[]> {
    return this.http.get<Location[]>(`${this.apiUrl}/vehicule/${vehicleId}`);
  }

  createLocation(location: Location): Observable<Location> {
    return this.http.post<Location>(this.apiUrl, location);
  }

  updateLocation(id: number, location: Location): Observable<Location> {
    return this.http.put<Location>(`${this.apiUrl}/${id}`, location);
  }

  deleteLocation(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
