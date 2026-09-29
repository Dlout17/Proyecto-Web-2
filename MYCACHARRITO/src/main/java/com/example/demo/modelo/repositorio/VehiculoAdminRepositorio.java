package com.example.demo.modelo.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.VehiculoAdmin;

import jakarta.transaction.Transactional;

@Repository
public interface VehiculoAdminRepositorio extends JpaRepository<VehiculoAdmin, Long> {

  
    @Query(value = "SELECT * FROM vehiculos WHERE estado = 'alquilado'", nativeQuery = true)
    List<VehiculoAdmin> listarVehiculosAlquiladosNoEntregados();

    
    @Query(value = "SELECT * FROM vehiculos WHERE tipo = :tipo AND estado = 'disponible'", nativeQuery = true)
    List<VehiculoAdmin> listarDisponiblesPorTipo(@Param("tipo") String tipo);

   
    @Modifying
    @Transactional
    @Query(value = "UPDATE vehiculos SET estado = 'entregado' WHERE placa = :placa", nativeQuery = true)
    int cambiarEstadoAEntregado(@Param("placa") String placa);

    
    @Query(value = "SELECT * FROM vehiculos WHERE id = :idAlquiler", nativeQuery = true)
    Optional<VehiculoAdmin> buscarPorNumeroAlquiler(@Param("idAlquiler") Long idAlquiler);

    
    @Modifying
    @Transactional
    @Query(value = "UPDATE vehiculos SET estado = 'disponible' WHERE id = :idAlquiler", nativeQuery = true)
    int cambiarEstadoADisponiblePorAlquiler(@Param("idAlquiler") Long idAlquiler);

}
