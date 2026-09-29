package com.example.demo.modelo;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "alquiler")

public class Alquiler {
	 @Id
	    private String numeroAlquiler;

	    private String nombreUsuario;
	    private String idUsuario;
	    private String tipoVehiculo;
	    private String placa;
	    private String color;
	    private LocalDate fechaInicio;
	    private LocalDate fechaEntrega;
	    private double valorTotal;
	    private String estado;

	    public Alquiler() {
	    }

	    public String getNumeroAlquiler() {
	        return numeroAlquiler;
	    }

	    public void setNumeroAlquiler(String numeroAlquiler) {
	        this.numeroAlquiler = numeroAlquiler;
	    }

	    public String getNombreUsuario() {
	        return nombreUsuario;
	    }

	    public void setNombreUsuario(String nombreUsuario) {
	        this.nombreUsuario = nombreUsuario;
	    }

	    public String getIdUsuario() {
	        return idUsuario;
	    }

	    public void setIdUsuario(String idUsuario) {
	        this.idUsuario = idUsuario;
	    }

	    public String getTipoVehiculo() {
	        return tipoVehiculo;
	    }

	    public void setTipoVehiculo(String tipoVehiculo) {
	        this.tipoVehiculo = tipoVehiculo;
	    }

	    public String getPlaca() {
	        return placa;
	    }

	    public void setPlaca(String placa) {
	        this.placa = placa;
	    }

	    public String getColor() {
	        return color;
	    }

	    public void setColor(String color) {
	        this.color = color;
	    }

	    public LocalDate getFechaInicio() {
	        return fechaInicio;
	    }

	    public void setFechaInicio(LocalDate fechaInicio) {
	        this.fechaInicio = fechaInicio;
	    }

	    public LocalDate getFechaEntrega() {
	        return fechaEntrega;
	    }

	    public void setFechaEntrega(LocalDate fechaEntrega) {
	        this.fechaEntrega = fechaEntrega;
	    }

	    public double getValorTotal() {
	        return valorTotal;
	    }

	    public void setValorTotal(double valorTotal) {
	        this.valorTotal = valorTotal;
	    }

	    public String getEstado() {
	        return estado;
	    }

	    public void setEstado(String estado) {
	        this.estado = estado;
	    }
}
