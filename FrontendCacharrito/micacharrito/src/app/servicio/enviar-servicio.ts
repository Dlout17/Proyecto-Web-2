import { inject, Injectable, PLATFORM_ID, Service, signal } from '@angular/core';
import { UsuarioE } from '../entities/usuario-e';
import { isPlatformBrowser } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class EnviarServicio {
    private platformId = inject(PLATFORM_ID);
  public usuarioSignal = signal<UsuarioE | null>(this.obtenerUsuarioInicial());

  private obtenerUsuarioInicial(): UsuarioE | null {
    if (isPlatformBrowser(this.platformId)) {
      const data = localStorage.getItem('usuarioActual');
      return data ? JSON.parse(data) : null;
    }
    return null;
  }

  enviar(usuario: UsuarioE) {
    console.log('Guardando usuario en sesión:', usuario);
    this.usuarioSignal.set(usuario);
    if (isPlatformBrowser(this.platformId)) {
      localStorage.setItem('usuarioActual', JSON.stringify(usuario));
    }
  }

  limpiar() {
    this.usuarioSignal.set(null);
    if (isPlatformBrowser(this.platformId)) {
      localStorage.removeItem('usuarioActual');
    }
  }

  estaAutenticado(): boolean {
    return this.usuarioSignal() !== null;
  }

  esAdmin(): boolean {
    return this.usuarioSignal()?.rol === 'ADMIN';
  }
}
