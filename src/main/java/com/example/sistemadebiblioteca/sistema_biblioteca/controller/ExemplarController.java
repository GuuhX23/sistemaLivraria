package com.example.sistemadebiblioteca.sistema_biblioteca.controller;

import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Exemplar;
import com.example.sistemadebiblioteca.sistema_biblioteca.service.ExemplarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exemplares")
public class ExemparController {

    private final ExemplarService exemplarService;

    public ExemparController(ExemplarService exemplarService) {
        this.exemplarService = exemplarService;
    }

    @GetMapping("/{id}")
    public Optional<Exemplar> buscarId(@PathVariable Long id) {
        return exemplarService.buscarId(id);
    }

    @GetMapping
    public List<Exemplar> listarTodos() {
        return exemplarService.listarTodos();
    }

    @PostMapping
    public Exemplar salvarExemplar(@RequestBody Exemplar exemplar) {
        return exemplarService.salvarExemplar(exemplar);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        exemplarService.deletar(id);
    }
}
