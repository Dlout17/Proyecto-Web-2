package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Vehiculo;
import com.example.demo.modelo.repositorio.vehiculorepositorio;

@RestController
@RequestMapping("/vehiculo/v/")
@CrossOrigin(origins="http://localhost:4200/")
public class controladoravehiculo {
	
	 @Autowired
	 private vehiculorepositorio Repovehiculo;
	 
	 @PostMapping("/guardar/")
	    public Vehiculo guardarVehiculo(@RequestBody Vehiculo vehiculo) {
	        return Repovehiculo.save(vehiculo);
	    }
}
