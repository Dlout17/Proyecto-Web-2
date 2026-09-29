import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Alquiler } from '../entities/alquiler';

@Injectable({
  providedIn: 'root'
})
export class AlquilerService {

    constructor(private httpCliente: HttpClient){}

    private listaA = 'http://localhost:8080/alquiler/listar'
    private guardarA = 'http://localhost:8080/alquiler/guardar'
    private buscarA = 'http://localhost:8080/alquiler/buscarAlquiler'
    private buscarUsuarioA = 'http://localhost:8080/alquiler/buscarUsuario'
    private buscarEstadoA = 'http://localhost:8080/alquiler/buscarEstado'
    private buscarPlacaA = 'http://localhost:8080/alquiler/buscarPlaca'
    private buscarFechaInicioA = 'http://localhost:8080/alquiler/buscarFecha-inicio'
    private buscarFechaEntregaA = 'http://localhost:8080/alquiler/buscarFecha-entrega'
    private buscarPlacaEstadoA = 'http://localhost:8080/alquiler/buscarPlaca-estado'
    private buscarRangoA = 'http://localhost:8080/alquiler/buscarRrango'
    private cantidadEstadoA = 'http://localhost:8080/alquiler/cantidad-estado'
    private buscarUsuarioEstadoA = 'http://localhost:8080/alquiler/buscarUsuario-estado'
    private actualizarA = 'http://localhost:8080/alquiler/actualizar'
    private cancelarA = 'http://localhost:8080/alquiler/cancelar'
    private eliminarA = 'http://localhost:8080/alquiler/eliminar'
    private pdfA = 'http://localhost:8080/alquiler/pdf'


    listarAlquileres(): Observable<any>{
        return this.httpCliente.get(this.listaA)
    }


    guardarAlquiler(alquiler: Alquiler): Observable<any>{
        return this.httpCliente.post(`${this.guardarA}`, alquiler)
    }


    buscarAlquiler(numeroAlquiler: string): Observable<any>{
        return this.httpCliente.get(
            `${this.buscarA}?numeroAlquiler=${numeroAlquiler}`
        )
    }


    buscarPorUsuario(idUsuario: string): Observable<any>{
        return this.httpCliente.get(
            `${this.buscarUsuarioA}?idUsuario=${idUsuario}`
        )
    }


    buscarPorEstado(estado: string): Observable<any>{
        return this.httpCliente.get(
            `${this.buscarEstadoA}?estado=${estado}`
        )
    }


    buscarPorPlaca(placa: string): Observable<any>{
        return this.httpCliente.get(
            `${this.buscarPlacaA}?placa=${placa}`
        )
    }


    buscarPorFechaInicio(fechaInicio: string): Observable<any>{
        return this.httpCliente.get(
            `${this.buscarFechaInicioA}?fechaInicio=${fechaInicio}`
        )
    }


    buscarPorFechaEntrega(fechaEntrega: string): Observable<any>{
        return this.httpCliente.get(
            `${this.buscarFechaEntregaA}?fechaEntrega=${fechaEntrega}`
        )
    }


    buscarPorPlacaEstado(placa: string, estado: string): Observable<any>{
        return this.httpCliente.get(
            `${this.buscarPlacaEstadoA}?placa=${placa}&estado=${estado}`
        )
    }


    buscarPorRango(fechaInicio: string, fechaFin: string): Observable<any>{
        return this.httpCliente.get(
            `${this.buscarRangoA}?fechaInicio=${fechaInicio}&fechaFin=${fechaFin}`
        )
    }


    cantidadPorEstado(estado: string): Observable<any>{
        return this.httpCliente.get(
            `${this.cantidadEstadoA}?estado=${estado}`
        )
    }


    buscarUsuarioEstado(idUsuario: string, estado: string): Observable<any>{
        return this.httpCliente.get(
            `${this.buscarUsuarioEstadoA}?idUsuario=${idUsuario}&estado=${estado}`
        )
    }


    actualizarAlquiler(alquiler: Alquiler): Observable<any>{
        return this.httpCliente.put(
            `${this.actualizarA}`,
            alquiler
        )
    }


    cancelarAlquiler(numeroAlquiler: string): Observable<any>{
        return this.httpCliente.put(
            `${this.cancelarA}?numeroAlquiler=${numeroAlquiler}`,
            null,
            { responseType: 'text' }
        )
    }


    eliminarAlquiler(numeroAlquiler: string): Observable<any>{
        return this.httpCliente.delete(
            `${this.eliminarA}?numeroAlquiler=${numeroAlquiler}`,
            { responseType: 'text' }
        )
    }


    generarPDF(numeroAlquiler: string): Observable<any>{
        return this.httpCliente.get(
            `${this.pdfA}?numeroAlquiler=${numeroAlquiler}`,
            { responseType: 'blob' }
        )
    }

}