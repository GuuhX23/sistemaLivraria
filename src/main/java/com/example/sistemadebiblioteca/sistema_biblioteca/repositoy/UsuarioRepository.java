package com.example.sistemadebiblioteca.sistema_biblioteca.repositoy;

import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
