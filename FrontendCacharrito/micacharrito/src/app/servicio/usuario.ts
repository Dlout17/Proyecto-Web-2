import { HttpClient } from '@angular/common/http';
import { Injectable, Service } from '@angular/core';
import { Observable } from 'rxjs';
import { UsuarioE } from '../entities/usuario-e';

@Injectable({
  providedIn: 'root'
})
export class Usuario {

    constructor(private httpCliente: HttpClient) { }

  private listaU = "http://localhost:8080/usuarios/u/listartodo/";
  private guardarU = "http://localhost:8080/usuarios/u/guardarUsuario/";
  private loginU = "http://localhost:8080/usuarios/u/login/";
  private buscarU = "http://localhost:8080/usuarios/u/buscarPorId/";
  private eliminarU = "http://localhost:8080/usuarios/u/eliminarUsuario/";

  listarUsuarios(): Observable<UsuarioE[]> {
    return this.httpCliente.get<UsuarioE[]>(this.listaU);
  }

  guardarUsuario(usuario: UsuarioE): Observable<UsuarioE> {
    return this.httpCliente.post<UsuarioE>(this.guardarU, usuario);
  }

  login(identificacion: string, password: string): Observable<UsuarioE> {
    return this.httpCliente.post<UsuarioE>(`${this.loginU}?identificacion=${identificacion}&password=${password}`,null);
  }

  buscarPorId(identificacion: string): Observable<UsuarioE> {
    return this.httpCliente.post<UsuarioE>(`${this.buscarU}?identificacion=${identificacion}`,null);
  }

  eliminarUsuario(identificacion: string): Observable<any> {
    return this.httpCliente.post(this.eliminarU, identificacion);
  }
}

