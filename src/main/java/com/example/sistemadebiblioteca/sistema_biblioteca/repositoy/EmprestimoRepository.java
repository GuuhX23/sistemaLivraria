package com.example.sistemadebiblioteca.sistema_biblioteca.repositoy;

import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
