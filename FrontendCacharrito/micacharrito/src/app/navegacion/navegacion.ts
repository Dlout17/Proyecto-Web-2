import { Component, inject } from '@angular/core';
import { EnviarServicio } from '../servicio/enviar-servicio';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  imports: [RouterOutlet, RouterLink, CommonModule],
  selector: 'app-navegacion',
  styleUrl: './navegacion.css',
  templateUrl: './navegacion.html',
})
export class Navegacion {
  dataService = inject(EnviarServicio);
  router = inject(Router);

  cerrarSesion() {
    this.dataService.limpiar();
    this.router.navigate(['/login']);
  }
}
