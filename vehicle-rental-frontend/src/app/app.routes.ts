import { Routes } from '@angular/router';
import { AuthGuard } from './guards/auth.guard';
import { RoleGuard } from './guards/role.guard';

export const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'login', loadComponent: () => import('./pages/login/login.component').then(m => m.LoginComponent) },
  { path: 'register', loadComponent: () => import('./pages/register/register.component').then(m => m.RegisterComponent) },
  
  {
    path: 'dashboard',
    canActivate: [AuthGuard],
    loadComponent: () => import('./pages/dashboard/dashboard.component').then(m => m.DashboardComponent)
  },
  
  {
    path: 'vehicules',
    canActivate: [AuthGuard],
    loadComponent: () => import('./pages/vehicules/vehicules.component').then(m => m.VehiculesComponent)
  },
  
  {
    path: 'locations',
    canActivate: [AuthGuard, RoleGuard],
    data: { roles: ['ROLE_CLIENT', 'ROLE_EMPLOYE', 'ROLE_ADMIN'] },
    loadComponent: () => import('./pages/locations/locations.component').then(m => m.LocationsComponent)
  },
  
  {
    path: 'agences',
    canActivate: [AuthGuard, RoleGuard],
    data: { roles: ['ROLE_EMPLOYE', 'ROLE_ADMIN'] },
    loadComponent: () => import('./pages/agences/agences.component').then(m => m.AgencesComponent)
  },
  
  {
    path: 'gestion-vehicules',
    canActivate: [AuthGuard, RoleGuard],
    data: { roles: ['ROLE_EMPLOYE', 'ROLE_ADMIN'] },
    loadComponent: () => import('./pages/gestion-vehicules/gestion-vehicules.component').then(m => m.GestionVehiculesComponent)
  },
  
  {
    path: 'access-denied',
    loadComponent: () => import('./pages/access-denied/access-denied.component').then(m => m.AccessDeniedComponent)
  },
  
  { path: '**', redirectTo: '/dashboard' }
];
