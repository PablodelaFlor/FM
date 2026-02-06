import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Sesion } from '../models/sesion';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SesionService {
   private baseUrl: string = 'http://localhost:8080/api/sesiones';

  constructor(private http: HttpClient) {}

  listar(): Observable<Sesion[]> {
    return this.http.get<Sesion[]>(this.baseUrl);
  }

  obtener(id: number): Observable<Sesion> {
    return this.http.get<Sesion>(`${this.baseUrl}/${id}`);
  }

  crear(s: Sesion): Observable<Sesion> {
    return this.http.post<Sesion>(this.baseUrl, s);
  }

  actualizar(id: number, s: Sesion): Observable<Sesion> {
    return this.http.put<Sesion>(`${this.baseUrl}/${id}`, s);
  }

  borrar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  porFecha(fecha: string): Observable<Sesion[]> {
    return this.http.get<Sesion[]>(`${this.baseUrl}/fecha?fecha=${fecha}`);
  }

  porCategoria(categoria: string): Observable<Sesion[]> {
    return this.http.get<Sesion[]>(`${this.baseUrl}/categoria/${categoria}`);
  }

  cambiarEstado(id: number, estado: string): Observable<Sesion> {
    return this.http.put<Sesion>(`${this.baseUrl}/${id}/estado/${estado}`, {});
  }
}
