package com.example.demo.modelo.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.VehiculoAdmin;
import com.example.demo.modelo.Vehiculo;

import jakarta.transaction.Transactional;

@Repository
public interface VehiculoAdminRepositorio extends JpaRepository<VehiculoAdmin, Long> {
	Optional<VehiculoAdmin> findByPlaca(String placa);

    
    @Query("SELECT v FROM VehiculoAdmin v WHERE v.estado = 'ALQUILADO'")
    List<VehiculoAdmin> listarVehiculosAlquiladosNoEntregados();

    
    @Query("SELECT v FROM Vehiculo v WHERE LOWER(v.tipo) = LOWER(:tipo) AND v.estado = 'DISPONIBLE'")
    List<Vehiculo> listarDisponiblesPorTipo(@Param("tipo") String tipo);

    
    @Modifying
    @Transactional
    @Query("UPDATE VehiculoAdmin v SET v.estado = 'ENTREGADO' WHERE v.placa = :placa")
    int cambiarEstadoAEntregado(@Param("placa") String placa);

   
    @Query("SELECT v FROM VehiculoAdmin v WHERE v.id = :idAlquiler")
    Optional<VehiculoAdmin> buscarPorNumeroAlquiler(@Param("idAlquiler") Long idAlquiler);

    
    @Modifying
    @Transactional
    @Query("UPDATE VehiculoAdmin v SET v.estado = 'DISPONIBLE' WHERE v.id = :idAlquiler")
    int cambiarEstadoADisponiblePorAlquiler(@Param("idAlquiler") Long idAlquiler);

}