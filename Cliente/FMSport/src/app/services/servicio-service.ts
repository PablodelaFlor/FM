import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Servicio } from '../models/servicio';

@Injectable({
  providedIn: 'root',
})
export class ServicioService {
   private baseUrl: string = 'http://localhost:8080/api/servicios';

  constructor(private http: HttpClient) {}

  listar(): Observable<Servicio[]> {
    return this.http.get<Servicio[]>(this.baseUrl);
  }

  obtener(id: number): Observable<Servicio> {
    return this.http.get<Servicio>(`${this.baseUrl}/${id}`);
  }

  crear(s: Servicio): Observable<Servicio> {
    return this.http.post<Servicio>(this.baseUrl, s);
  }

  actualizar(id: number, s: Servicio): Observable<Servicio> {
    return this.http.put<Servicio>(`${this.baseUrl}/${id}`, s);
  }

  borrar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
