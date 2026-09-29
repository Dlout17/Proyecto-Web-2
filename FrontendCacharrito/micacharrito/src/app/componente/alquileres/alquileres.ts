import { Component,OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AlquilerService } from '../../servicio/alquiler';
import { Alquiler } from '../../entities/alquiler';
import { ActivatedRoute } from '@angular/router'; 


@Component({
  selector: 'app-alquileres',
  imports: [FormsModule],
  templateUrl: './alquileres.html',
  styleUrl: './alquileres.css'
})
export class Alquileres implements OnInit{

  listaAlquileres: Alquiler[] = [];

  alquiler: Alquiler = new Alquiler();

  numeroBuscar: string = '';

  modalAbierto: boolean = false;

  constructor(
    private servicioAlquiler: AlquilerService,
    private route: ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.listarAlquileres();

    this.route.queryParams.subscribe(params => {
  if (params['placa']) {
    this.alquiler = new Alquiler();
    (this.alquiler as any).placa = params['placa'];
    (this.alquiler as any).color = params['color']; 
    this.alquiler.tipoVehiculo = params['tipoVehiculo'] || '';  
    if (params['valor']) {
      this.alquiler.valorTotal = +params['valor'];
    }
    this.modalAbierto = true;
  }
});
  }
listarAlquileres() {
  this.servicioAlquiler.listarAlquileres().subscribe({
    next: (datos) => {

      this.listaAlquileres = datos.filter((alquiler: null) => alquiler != null);

    },
    error: (error) => {
      console.log(error);
    }
  });
}

 buscarAlquiler() {

  this.servicioAlquiler.buscarAlquiler(this.numeroBuscar).subscribe({

    next: (dato) => {

      if (dato != null) {

        this.listaAlquileres = [dato];

      } else {

        this.listaAlquileres = [];

        alert('Alquiler no encontrado');

      }

    },

    error: (error) => {

      console.log(error);

      this.listaAlquileres = [];

      alert('Alquiler no encontrado');

    }

  });

}

  abrirModal() {

    this.alquiler = new Alquiler();

    this.modalAbierto = true;

  }

  cerrarModal() {

    this.modalAbierto = false;

    this.alquiler = new Alquiler();

  }

  guardarAlquiler() {

    this.servicioAlquiler.guardarAlquiler(this.alquiler).subscribe({
      next: (dato) => {

        alert('Alquiler guardado correctamente');

        this.alquiler = new Alquiler();

        this.listarAlquileres();

        this.cerrarModal();

      },
      error: (error) => {

        console.log(error);
        alert('Error al guardar el alquiler');

      }
    });

  }

  seleccionarAlquiler(alquiler: Alquiler) {

    this.alquiler = alquiler;

    this.modalAbierto = true;

  }

  actualizarAlquiler() {

    this.servicioAlquiler.actualizarAlquiler(this.alquiler).subscribe({
      next: (dato) => {

        alert('Alquiler actualizado correctamente');

        this.alquiler = new Alquiler();

        this.listarAlquileres();

        this.cerrarModal();

      },
      error: (error) => {

        console.log(error);
        alert('Error al actualizar');

      }
    });

  }

  cancelarAlquiler(numeroAlquiler: string) {

    this.servicioAlquiler.cancelarAlquiler(numeroAlquiler).subscribe({
      next: (mensaje) => {

        alert(mensaje);

        this.listarAlquileres();

      },
      error: (error) => {

        console.log(error);

      }
    });

  }

  eliminarAlquiler(numeroAlquiler: string) {

    this.servicioAlquiler.eliminarAlquiler(numeroAlquiler).subscribe({
      next: (mensaje) => {

        alert(mensaje);

        this.listarAlquileres();

      },
      error: (error) => {

        console.log(error);

      }
    });

  }

  generarPDF(numeroAlquiler: string) {

    this.servicioAlquiler.generarPDF(numeroAlquiler).subscribe({

        next: (archivo) => {

            const url = window.URL.createObjectURL(archivo);

            const enlace = document.createElement('a');

            enlace.href = url;

            enlace.download = 'alquiler-' + numeroAlquiler + '.pdf';

            enlace.click();

            window.URL.revokeObjectURL(url);
        },

        error: (error) => {

            console.log(error);

            alert('Error al generar el PDF');
        }

    });

}

}