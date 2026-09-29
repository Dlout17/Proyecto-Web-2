package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Vehiculo;
import com.example.demo.modelo.repositorio.vehiculorepositorio;

@RestController
@RequestMapping("/vehiculo/v/")
@CrossOrigin(origins="http://localhost:4200/")
public class controladoravehiculo {
	
	 @Autowired
	 private vehiculorepositorio Repovehiculo;
	 
	 @PostMapping("/guardar")
	    public Vehiculo guardarVehiculo(@RequestBody Vehiculo vehiculo) {
		 if (vehiculo.getEstado() == null || vehiculo.getEstado().trim().isEmpty()) {
		        vehiculo.setEstado("DISPONIBLE");
		    }
	        return Repovehiculo.save(vehiculo);
	    }
	 
	 @GetMapping("/disponibles")
	    public List<Vehiculo> obtenerDisponiblesPorTipo(@RequestParam("tipo") String tipo) {
	        if (tipo == null || tipo.trim().isEmpty()) {
	            return List.of();
	        }
	        return Repovehiculo.buscarVehiculosDisponiblesPorTipo(tipo);
	    }
	 
	 @GetMapping("/listarTodos")
	    public List<Vehiculo> listarTodos() {
	        return Repovehiculo.findAll();
	    }
}
