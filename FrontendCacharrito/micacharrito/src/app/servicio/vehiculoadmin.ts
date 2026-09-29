import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Vehiculoadmin {
     private baseUrl = 'http://localhost:8080/admin/vehiculos';
      private guardarVehiculos = "http://localhost:8080/vehiculo/v/guardar";

  constructor(private http: HttpClient) { }

  listarTodos(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/listarTodo`);
  }

  listarAlquiladosNoEntregados(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/alquiladosNoEntregados`);
  }

  listarDisponiblesPorTipo(tipo: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/disponiblesPorTipo?tipo=${tipo}`);
  }

  cambiarEstadoEntregado(placa: string): Observable<any> {
    return this.http.put(`${this.baseUrl}/cambiarEstadoEntregado?placa=${placa}`, {}, { responseType: 'text' });
  }

  procesarDevolucion(idAlquiler: number, fechaRealEntrega: string): Observable<any> {
    return this.http.put(`${this.baseUrl}/procesarDevolucion/${idAlquiler}?fechaRealEntrega=${fechaRealEntrega}`, {}, { responseType: 'text' });
  }

  guardarVehiculo(vehiculo: any): Observable<any> {
    return this.http.post(this.guardarVehiculos, vehiculo);
  }
}
