  import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
  import { CommonModule } from '@angular/common';
  import { FormsModule } from '@angular/forms';
  import { Vehiculoadmin } from '../../servicio/vehiculoadmin';

  @Component({
    selector: 'app-vehiculo-admin',
    standalone: true,
    imports: [CommonModule, FormsModule],
    templateUrl: './vehiculoadmin.html',
    styleUrls: ['./vehiculoadmin.css']
  })
  export class VehiculoAdmin implements OnInit {
    vehiculos: any[] = [];
    placaInput: string = '';
    idAlquilerInput: number | null = null;
    fechaDevolucionInput: string = '';
    mensajeAccion: string = '';
    tiposVehiculo: string[] = ['automovil', 'camioneta', 'campero', 'microbus', 'motocicleta'];
    tipoSeleccionado: string = '';
    vehiculosDisponibles: any[] = [];
    listaVehiculos: any[] = []; 
    placa: string = '';
    tipoNuevo: string = 'automovil';
    color: string = '';
    valorAlquiler: number | null = null;


    constructor(private vehiculoService: Vehiculoadmin,
      private cd: ChangeDetectorRef
    ) {}

    ngOnInit(): void {
      this.vehiculos = [];
    }

    cargarTodos() {
      this.vehiculoService.listarTodos().subscribe({
        next: (data) => { this.vehiculos = data; },
        error: (err) => { console.error('Error al cargar vehículos', err); }
      });
    }

    cargarAlquiladosNoEntregados() {
      this.vehiculoService.listarAlquiladosNoEntregados().subscribe({
        next: (data) => { this.vehiculos = data; },
        error: (err) => { console.error('Error al cargar alquilados', err); }
      });
    }

    cargarDisponiblesPorTipo() {
      if (!this.tipoSeleccionado) return;
      this.vehiculoService.listarDisponiblesPorTipo(this.tipoSeleccionado).subscribe({
        next: (data) => { this.vehiculos = data; },
        error: (err) => { console.error('Error al filtrar por tipo', err); }
      });
    }

    entregarVehiculo() {
      if (!this.placaInput) {
        alert("Por favor ingresa una placa");
        return;
      }
      this.vehiculoService.cambiarEstadoEntregado(this.placaInput).subscribe({
        next: (res) => {
          this.mensajeAccion = res;
          this.placaInput = '';
          this.cargarAlquiladosNoEntregados();
        },
        error: (err) => { alert("Error al cambiar estado: " + (err.error || err.message)); }
      });
    }

    procesarDevolucion() {
      if (!this.idAlquilerInput || !this.fechaDevolucionInput) {
        alert("Ingresa el ID de alquiler y la fecha real de entrega");
        return;
      }
      this.vehiculoService.procesarDevolucion(this.idAlquilerInput, this.fechaDevolucionInput).subscribe({
        next: (res) => {
          this.mensajeAccion = res;
          this.idAlquilerInput = null;
          this.fechaDevolucionInput = '';
          this.cargarAlquiladosNoEntregados();
        },
        error: (err) => { 
          const mensajeError = err.error || "No se encontró el vehículo o el ID de alquiler es inválido.";
          alert("Error al procesar devolución: " + mensajeError); 
        }
      });
    }

    buscarVehiculosPorTipo() {
      if (!this.tipoSeleccionado || this.tipoSeleccionado.trim() === '') {
        alert("Por favor seleccione un tipo de vehículo.");
        return;
      }
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

      this.vehiculoService.guardarVehiculo(nuevoVehiculo).subscribe({
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