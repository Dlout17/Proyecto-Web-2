package com.example.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Usuario;
import com.example.demo.modelo.repositorio.UsuarioRepository;

@RestController
@RequestMapping("/usuarios/u/")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorUsuario {
	
	@Autowired
    private UsuarioRepository repoUsuario;

    @GetMapping("/listartodo/")
    public List<Usuario> mostrarUsuarios() {
        return this.repoUsuario.findAll();
    }

    @PostMapping("/guardarUsuario/")
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario u) {
        if (u.getRol() == null || u.getRol().trim().isEmpty()) {
            u.setRol("CLIENTE");
        }
        Usuario usuarioGuardado = this.repoUsuario.save(u);
        return ResponseEntity.ok(usuarioGuardado);
    }

    @PostMapping("/login/")
    public ResponseEntity<Usuario> login(@RequestParam("identificacion") String identificacion, 
                                         @RequestParam("password") String password) {
        Optional<Usuario> user = this.repoUsuario.iniciarSesion(identificacion, password);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/buscarPorId/")
    public Usuario buscarPorId(@RequestParam("identificacion") String identificacion) {
        return this.repoUsuario.findById(identificacion).orElse(null);
    }

    @PostMapping("/eliminarUsuario/")
    public ResponseEntity<Void> eliminarUsuario(@RequestBody String identificacion) {
        this.repoUsuario.deleteById(identificacion);
        return ResponseEntity.ok().build();
    }
}
