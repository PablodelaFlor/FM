import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Reserva } from '../models/reserva';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ReservaService {
  private baseUrl: string = 'http://localhost:8080/api/reservas';

  constructor(private http: HttpClient) {}

  listar(): Observable<Reserva[]> {
    return this.http.get<Reserva[]>(this.baseUrl);
  }

  obtener(id: number): Observable<Reserva> {
    return this.http.get<Reserva>(`${this.baseUrl}/${id}`);
  }

  crear(r: Reserva): Observable<Reserva> {
    return this.http.post<Reserva>(this.baseUrl, r);
  }

  actualizar(id: number, r: Reserva): Observable<Reserva> {
    return this.http.put<Reserva>(`${this.baseUrl}/${id}`, r);
  }

  borrar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  porCliente(clienteId: number): Observable<Reserva[]> {
    return this.http.get<Reserva[]>(`${this.baseUrl}/cliente/${clienteId}`);
  }

  porSesion(sesionId: number): Observable<Reserva[]> {
    return this.http.get<Reserva[]>(`${this.baseUrl}/sesion/${sesionId}`);
  }

  cancelar(id: number): Observable<Reserva> {
    return this.http.put<Reserva>(`${this.baseUrl}/${id}/cancelar`, {});
  }
}
