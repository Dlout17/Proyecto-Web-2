package com.example.demo.modelo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="usuario")
public class Usuario {
	
	@Id
    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_expedicion_licencia")
    private Date fechaExpedicionLicencia;

    @Column(name = "categoria")
    private String categoria;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "vigencia")
    private Date vigencia;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "password")
    private String password;

    @Column(name = "rol")
    private String rol;
	

    public Usuario() {}

    public Usuario(String identificacion, String nombreCompleto, Date fechaExpedicionLicencia, 
                   String categoria, Date vigencia, String correo, String telefono, 
                   String password, String rol) {
        this.identificacion = identificacion;
        this.nombreCompleto = nombreCompleto;
        this.fechaExpedicionLicencia = fechaExpedicionLicencia;
        this.categoria = categoria;
        this.vigencia = vigencia;
        this.correo = correo;
        this.telefono = telefono;
        this.password = password;
        this.rol = rol;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Date getFechaExpedicionLicencia() {
        return fechaExpedicionLicencia;
    }

    public void setFechaExpedicionLicencia(Date fechaExpedicionLicencia) {
        this.fechaExpedicionLicencia = fechaExpedicionLicencia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
