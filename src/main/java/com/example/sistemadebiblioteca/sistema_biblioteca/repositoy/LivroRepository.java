package com.example.sistemadebiblioteca.sistema_biblioteca.repositoy;

import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
