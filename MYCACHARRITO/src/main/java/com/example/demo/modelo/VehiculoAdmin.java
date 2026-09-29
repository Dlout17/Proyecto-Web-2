package com.example.demo.modelo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vehiculosadmin")
public class VehiculoAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String tipo;      
    private String estado;   
    
    private LocalDate fechaAlquiler;
    private LocalDate fechaEntregaEstimada;
    
    
   
	public VehiculoAdmin() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}
	public void setFechaAlquiler(LocalDate fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}
	public LocalDate getFechaEntregaEstimada() {
		return fechaEntregaEstimada;
	}
	public void setFechaEntregaEstimada(LocalDate fechaEntregaEstimada) {
		this.fechaEntregaEstimada = fechaEntregaEstimada;
	}
	public VehiculoAdmin(Long id, String placa, String tipo, String estado, LocalDate fechaAlquiler,
			LocalDate fechaEntregaEstimada) {
		super();
		this.id = id;
		this.placa = placa;
		this.tipo = tipo;
		this.estado = estado;
		this.fechaAlquiler = fechaAlquiler;
		this.fechaEntregaEstimada = fechaEntregaEstimada;
	}

	
    
}
