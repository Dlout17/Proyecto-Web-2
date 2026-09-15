package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @Column(name = "id_vehiculo")
    private Long idVehiculo;

    private String placa;

    private String color;

    private Double valorDiario;

    private Boolean disponible = true;

    
	public Vehiculo() {
		
	}

	public Vehiculo(Long idVehiculo, String placa, String color, Double valorDiario, Boolean disponible) {
	
		this.idVehiculo = idVehiculo;
		this.placa = placa;
		this.color = color;
		this.valorDiario = valorDiario;
		this.disponible = disponible;
	}

	public Long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
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

	public Double getValorDiario() {
		return valorDiario;
	}

	public void setValorDiario(Double valorDiario) {
		this.valorDiario = valorDiario;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}


    
    
}
