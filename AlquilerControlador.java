package com.example.demo.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repositorio.AlquilerRepositorio;
import com.example.demo.modelo.Alquiler;

@RestController
@RequestMapping("/alquiler")
@CrossOrigin(origins = "http://localhost:4200")
public class AlquilerControlador {
	  private final AlquilerRepositorio alquilerRepositorio;

	    public AlquilerControlador(AlquilerRepositorio alquilerRepositorio) {
	        this.alquilerRepositorio = alquilerRepositorio;
	    }

	    @GetMapping("/listar")
	    public List<Alquiler> listar() {
	        return alquilerRepositorio.findAll();
	    }

}
