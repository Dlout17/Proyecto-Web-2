package com.example.demo.modelo.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	@Query(value = "SELECT * FROM usuario WHERE identificacion = :identificacion AND password = :password", nativeQuery = true)
    public Optional<Usuario> iniciarSesion(@Param("identificacion") String identificacion, @Param("password") String password);

    public Optional<Usuario> findByCorreo(String correo);
}
