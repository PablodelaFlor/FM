import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ServicioService } from '../services/servicio-service';
import { Servicio } from '../models/servicio';
import { FormsModule, NgModel } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-servicios-component',
  imports: [RouterModule,FormsModule, CommonModule],
  templateUrl: './servicios-component.html',
  styleUrl: './servicios-component.css',
})
export class ServiciosComponent {

  servicios: Servicio[] = [];

  nuevo: Servicio = {
    nombre: '',
    categoria: 'PERSONAL',
    duracionMin: 60,
    precioBase: 0,
    descripcion: '',
    activo: true
  };

  constructor(private ss: ServicioService) {}

  ngOnInit(): void {
    this.cargar();
  }

  cargar(): void {
    this.ss.listar().subscribe(data => {
      this.servicios = data;
    });
  }

  crear(): void {
    this.ss.crear(this.nuevo).subscribe(() => {
      this.nuevo = {
        nombre: '',
        categoria: 'PERSONAL',
        duracionMin: 60,
        precioBase: 0,
        descripcion: '',
        activo: true
      };
      this.cargar();
    });
  }

  borrar(id: number): void {
    this.ss.borrar(id).subscribe(() => {
      this.cargar();
    });
  }
}
