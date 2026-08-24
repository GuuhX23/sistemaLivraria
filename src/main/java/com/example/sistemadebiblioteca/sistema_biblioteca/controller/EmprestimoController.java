package com.example.sistemadebiblioteca.sistema_biblioteca.controller;

import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Emprestimo;
import com.example.sistemadebiblioteca.sistema_biblioteca.service.EmprestimoService;
import com.example.sistemadebiblioteca.sistema_biblioteca.service.ExemplarService;
import com.example.sistemadebiblioteca.sistema_biblioteca.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;
    private final UsuarioService usuarioService;
    private final ExemplarService exemplarService;

    public EmprestimoController(EmprestimoService emprestimoService, UsuarioService usuarioService, ExemplarService exemplarService) {
        this.emprestimoService = emprestimoService;
        this.usuarioService = usuarioService;
        this.exemplarService = exemplarService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> buscarId(@PathVariable Long id) {
        Emprestimo emprestimo = emprestimoService.buscarId(id);
        return ResponseEntity.ok(emprestimo);
    }

    @GetMapping
    public ResponseEntity<List<Emprestimo>> listarTodos() {
        List<Emprestimo> emprestimos = emprestimoService.listarTodos();
        return ResponseEntity.ok(emprestimos);
    }

    @PostMapping
    public ResponseEntity<Emprestimo> salvarEmprestimo(@Valid @RequestParam Long usuarioId, @RequestParam Long exemplarId) {
       Emprestimo emprestimoSalvo = emprestimoService.salvarEmprestimo(usuarioId, exemplarId);
       return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        emprestimoService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
