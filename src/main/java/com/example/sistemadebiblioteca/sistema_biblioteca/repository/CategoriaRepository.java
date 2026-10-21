package com.example.sistemadebiblioteca.sistema_biblioteca.repository;

import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
