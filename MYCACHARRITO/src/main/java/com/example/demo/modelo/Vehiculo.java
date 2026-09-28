package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_vehiculo")
    private Long idVehiculo;

    private String placa;

    private String tipo; 
    private String color;

    @Column(name = "valor_alquiler")
    private Double valorAlquiler; 

    private String estado;

    public Vehiculo() {}

    public Vehiculo(String placa, String tipo, String color, Double valorAlquiler, String estado) {
        this.placa = placa;
        this.tipo = tipo;
        this.color = color;
        this.valorAlquiler = valorAlquiler;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getIdVehiculo() { return idVehiculo; }
    public void setIdVehiculo(Long idVehiculo) { this.idVehiculo = idVehiculo; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public Double getValorAlquiler() { return valorAlquiler; }
    public void setValorAlquiler(Double valorAlquiler) { this.valorAlquiler = valorAlquiler; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
