import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class vehiculo {
    private vehiculosPorTipos = "http://localhost:8080/vehiculo/v/disponibles";
  private guardarVehiculos = "http://localhost:8080/vehiculo/v/guardar";
  private todosVehiculos = "http://localhost:8080/vehiculo/v/listarTodos";

  constructor(private httpVehiculo: HttpClient) { }

  obtenerVehiculosDisponibles(tipo: string): Observable<any> {
    return this.httpVehiculo.get(`${this.vehiculosPorTipos}?tipo=${tipo}`);
  }

  guardarVehiculo(vehiculo: any): Observable<any> {
    return this.httpVehiculo.post(this.guardarVehiculos, vehiculo);
  }

  obtenerTodosLosVehiculos(): Observable<any> {
    return this.httpVehiculo.get(this.todosVehiculos);
  }
}

