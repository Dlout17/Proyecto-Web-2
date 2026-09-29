package com.example.demo.modelo.repositorio;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Alquiler;

@Repository

public interface AlquilerRepositorio extends JpaRepository<Alquiler, String>{

	List<Alquiler> findByIdUsuario(String idUsuario);
	List<Alquiler> findByEstado(String estado);
	List<Alquiler> findByPlaca(String placa);
	List<Alquiler> findByFechaInicio(LocalDate fechaInicio);
	List<Alquiler> findByFechaEntrega(LocalDate fechaEntrega);
    List<Alquiler> findByIdUsuarioAndEstado(String idUsuario, String estado);
    List<Alquiler> findByPlacaAndEstado(String placa, String estado);
	List<Alquiler> findByFechaInicioBetween(LocalDate fechaInicio, LocalDate fechaFin);
	long countByEstado(String estado);

	

}
	