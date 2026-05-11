import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { VehicleService, Vehicule } from '../../services/vehicle.service';

@Component({
  selector: 'app-vehicules',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './vehicules.component.html',
  styleUrl: './vehicules.component.css'
})
export class VehiculesComponent implements OnInit {
  vehicules: Vehicule[] = [];
  loading = false;
  error = '';

  constructor(
    private vehicleService: VehicleService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadVehicules();
  }

  loadVehicules(): void {
    this.loading = true;
    this.error = '';

    this.vehicleService.getAllVehicles().subscribe({
      next: (data) => {
        this.vehicules = data;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Erreur lors du chargement des véhicules';
        this.loading = false;
      }
    });
  }

  getStatusBadge(status: string): string {
    switch (status) {
      case 'DISPONIBLE':
        return 'badge-success';
      case 'LOUE':
        return 'badge-warning';
      case 'EN_MAINTENANCE':
        return 'badge-danger';
      default:
        return 'badge-info';
    }
  }

  back(): void {
    this.router.navigate(['/dashboard']);
  }
}
