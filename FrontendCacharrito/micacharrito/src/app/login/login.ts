import { Component, inject } from '@angular/core';
import { UsuarioE } from '../entities/usuario-e';
import { Usuario } from '../servicio/usuario';
import { EnviarServicio } from '../servicio/enviar-servicio';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [CommonModule,FormsModule],
  selector: 'app-login',
  styleUrl: './login.css',
  templateUrl: './login.html',
})
export class Login {
  identificacion: string = '';
  password: string = '';
  mensajeError: string = '';

  nuevoUsuario: UsuarioE = this.crearUsuarioVacio();

  private servicioUsuario = inject(Usuario);
  private dataService = inject(EnviarServicio);
  private router = inject(Router);

  private crearUsuarioVacio(): UsuarioE {
    const u = new UsuarioE();
    u.categoria = 'B1';
    u.rol = 'CLIENTE'; 
    return u;
  }

  iniciarSesion() {
    this.mensajeError = '';
    this.servicioUsuario.login(this.identificacion, this.password).subscribe({
      next: (usuario) => {
        this.dataService.enviar(usuario);
        alert(`¡Bienvenido ${usuario.nombreCompleto}!`);
        if (usuario.rol === 'ADMIN') {
          this.router.navigate(['/paneladmin']);
        } else {
          this.router.navigate(['/catalogo']);
        }
      },
      error: () => {
        this.mensajeError = 'Identificación o contraseña incorrectos.';
      }
    });
  }

  abrirModalRegistro() {
    this.nuevoUsuario = this.crearUsuarioVacio();
    const modal = document.getElementById("modalRegistro");
    if (modal != null) modal.style.display = 'block';
  }

  cerrarModalRegistro() {
    this.nuevoUsuario = this.crearUsuarioVacio();
    const modal = document.getElementById("modalRegistro");
    if (modal != null) modal.style.display = 'none';
  }

  registrarUsuario() {
    this.nuevoUsuario.rol = 'CLIENTE'; 
    this.servicioUsuario.guardarUsuario(this.nuevoUsuario).subscribe({
      next: () => {
        alert("Usuario registrado con éxito. Ya puedes iniciar sesión.");
        this.cerrarModalRegistro();
      },
      error: () => {
        alert("Error al registrar el usuario. Revisa los datos.");
      }
    });
  }
}