package com.example.demo.modelo;

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

	@Column(name = "fecha_expedicion_licencia")
	private String fechaExpedicionLicencia;

	@Column(name = "categoria_licencia")
	private String categoriaLicencia;

	@Column(name = "vigencia_licencia")
	private String vigenciaLicencia;

	@Column(name = "correo")
	private String correo;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "password")
	private String password;

	

	public Usuario() {}
	public Usuario(String identificacion, String nombreCompleto, String fechaExpedicionLicencia,
			String categoriaLicencia, String vigenciaLicencia, String correo, String telefono, String password) {
		
		this.identificacion = identificacion;
		this.nombreCompleto = nombreCompleto;
		this.fechaExpedicionLicencia = fechaExpedicionLicencia;
		this.categoriaLicencia = categoriaLicencia;
		this.vigenciaLicencia = vigenciaLicencia;
		this.correo = correo;
		this.telefono = telefono;
		this.password = password;
		
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
	public String getFechaExpedicionLicencia() {
		return fechaExpedicionLicencia;
	}
	public void setFechaExpedicionLicencia(String fechaExpedicionLicencia) {
		this.fechaExpedicionLicencia = fechaExpedicionLicencia;
	}
	public String getCategoriaLicencia() {
		return categoriaLicencia;
	}
	public void setCategoriaLicencia(String categoriaLicencia) {
		this.categoriaLicencia = categoriaLicencia;
	}
	public String getVigenciaLicencia() {
		return vigenciaLicencia;
	}
	public void setVigenciaLicencia(String vigenciaLicencia) {
		this.vigenciaLicencia = vigenciaLicencia;
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
	

}
