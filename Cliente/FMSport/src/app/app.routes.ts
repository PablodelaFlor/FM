import { Routes } from '@angular/router';
import { HomeComponent } from './home-component/home-component';
import { ServiciosComponent } from './servicios-component/servicios-component';
import { SesionesComponent } from './sesiones-component/sesiones-component';
import { ReservasComponent } from './reservas-component/reservas-component';

export const routes: Routes = [
   { path: 'home', component: HomeComponent },
  { path: 'servicios', component: ServiciosComponent },
  { path: 'sesiones', component: SesionesComponent },
  { path: 'reservas', component: ReservasComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: '**', redirectTo: 'home' }
];
