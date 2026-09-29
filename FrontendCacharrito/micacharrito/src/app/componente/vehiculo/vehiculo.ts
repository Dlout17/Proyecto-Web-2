import { Component, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { vehiculo } from '../../servicio/vehiculo';

@Component({
  imports: [CommonModule,FormsModule],
  selector: 'app-vehiculo',
  styleUrl: './vehiculo.css',
  templateUrl: './vehiculo.html',
})
export class Vehiculo {
  tiposVehiculo: string[] = ['automovil', 'camioneta', 'campero', 'microbus', 'motocicleta'];
  tipoSeleccionado: string = '';
  vehiculosDisponibles: any[] = [];
  listaVehiculos: any[] = []; 
  placa: string = '';
  tipoNuevo: string = 'automovil';
  color: string = '';
  valorAlquiler: number | null = null;

  constructor(
    private servicioVehiculo: vehiculo,
    private cd: ChangeDetectorRef
  ) {}

  buscarVehiculosPorTipo() {
    if (!this.tipoSeleccionado || this.tipoSeleccionado.trim() === '') {
      alert("Por favor seleccione un tipo de vehículo.");
      return;
    }

    this.servicioVehiculo.obtenerVehiculosDisponibles(this.tipoSeleccionado).subscribe({
      next: (dato: any) => {
        this.vehiculosDisponibles = dato;
        this.cd.detectChanges();
      },
      error: (err: any) => {
        alert("Ocurrió un error al obtener el catálogo de vehículos.");
      }
    });
  }

  registrarVehiculo() {
    if (!this.placa || !this.color || !this.valorAlquiler) {
      alert("Por favor complete todos los datos del vehículo.");
      return;
    }

    const nuevoVehiculo = {
      placa: this.placa,
      tipo: this.tipoNuevo,
      color: this.color,
      valorAlquiler: this.valorAlquiler,
      disponible: true
    };

    this.servicioVehiculo.guardarVehiculo(nuevoVehiculo).subscribe({
      next: (res: any) => {
        alert("Vehículo registrado con éxito.");
        this.limpiarFormularioGestion();
        
        if (this.tipoSeleccionado === this.tipoNuevo) {
          this.buscarVehiculosPorTipo();
        } else {
          this.cd.detectChanges();
        }
      },
      error: (err: any) => {
        alert("Ocurrió un error al registrar el vehículo.");
      }
    });
  }

 

  limpiarFormularioGestion() {
    this.placa = '';
    this.tipoNuevo = 'automovil';
    this.color = '';
    this.valorAlquiler = null;
  }

}
