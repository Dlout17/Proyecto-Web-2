package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Usuario;
import com.example.demo.modelo.repositorio.UsuarioRepository;

@RestController
@RequestMapping("/usuarios/u/")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorUsuario {
	
	@Autowired
    private UsuarioRepository usuarioRepo;
	
	@PostMapping("/registrar/")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

}
