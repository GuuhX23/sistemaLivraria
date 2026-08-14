package com.example.sistemadebiblioteca.sistema_biblioteca.repositoy;

import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Exemplar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {
}
