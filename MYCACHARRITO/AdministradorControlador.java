package com.example.demo.controlador;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Vehiculo;
import com.example.demo.modelo.repositorio.VehiculoRepositorio;

@RestController
@RequestMapping("/admin/vehiculos") 
@CrossOrigin(origins = "http://localhost:4200")
public class AdministradorControlador {

    @Autowired
    private VehiculoRepositorio repoVehiculo;

    @GetMapping("/listarTodo")
    public List<Vehiculo> mostrarTodos() {
        return repoVehiculo.findAll();
    }

    @GetMapping("/alquiladosNoEntregados")
    public List<Vehiculo> listarVehiculosAlquiladosNoEntregados() {
        return repoVehiculo.listarVehiculosAlquiladosNoEntregados();
    }

    @GetMapping("/disponiblesPorTipo")
    public List<Vehiculo> listarDisponiblesPorTipo(@RequestParam("tipo") String tipo) {
        return repoVehiculo.listarDisponiblesPorTipo(tipo);
    }

    @PutMapping("/cambiarEstadoEntregado")
    public String cambiarEstadoAEntregado(@Param("placa") String placa) {
        int filasModificadas = repoVehiculo.cambiarEstadoAEntregado(placa);
        return "Se actualizó el vehículo con placa " + placa + " a estado 'entregado'.";
    }

    @PutMapping("/procesarDevolucion/{idAlquiler}")
    public ResponseEntity<String> procesarDevolucion(@PathVariable("idAlquiler") Long idAlquiler, @RequestParam("fechaRealEntrega") String fechaRealEntregaStr) {
        Optional<Vehiculo> vehiculoOpt = repoVehiculo.buscarPorNumeroAlquiler(idAlquiler);
        
        if (vehiculoOpt.isPresent()) {
            Vehiculo vehiculo = vehiculoOpt.get();
            LocalDate fechaRealEntrega = LocalDate.parse(fechaRealEntregaStr);
            long diasRetraso = 0;
            double costoExtra = 0.0;

            if (vehiculo.getFechaEntregaEstimada() != null && fechaRealEntrega.isAfter(vehiculo.getFechaEntregaEstimada())) {
                diasRetraso = ChronoUnit.DAYS.between(vehiculo.getFechaEntregaEstimada(), fechaRealEntrega);
                costoExtra = diasRetraso * 50000.0; 
            }

            repoVehiculo.cambiarEstadoADisponiblePorAlquiler(idAlquiler);

            return ResponseEntity.ok("Devolución exitosa. Vehículo disponible de nuevo. Días de retraso cobrados: " + diasRetraso + " (Total extra: $" + costoExtra + ").");
        }
        
        return ResponseEntity.notFound().build();
    }
}