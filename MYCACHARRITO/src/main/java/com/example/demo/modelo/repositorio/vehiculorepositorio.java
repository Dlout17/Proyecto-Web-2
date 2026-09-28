package com.example.demo.modelo.repositorio;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modelo.Vehiculo;

public interface vehiculorepositorio extends JpaRepository <Vehiculo, Long> { 

	@Query(value = "SELECT * FROM vehiculos WHERE LOWER(tipo) = LOWER(:tipo) AND UPPER(estado) = 'DISPONIBLE'", nativeQuery = true)
    List<Vehiculo> buscarVehiculosDisponiblesPorTipo(@Param("tipo") String tipo);

	
}
