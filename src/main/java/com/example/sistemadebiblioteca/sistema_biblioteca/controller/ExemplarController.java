package com.example.sistemadebiblioteca.sistema_biblioteca.controller;

import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Exemplar;
import com.example.sistemadebiblioteca.sistema_biblioteca.service.ExemplarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exemplares")
public class ExemplarController {

    private final ExemplarService exemplarService;

    public ExemplarController(ExemplarService exemplarService) {
        this.exemplarService = exemplarService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exemplar> buscarId(@PathVariable Long id) {
        Optional<Exemplar> exemplar = exemplarService.buscarId(id);

        if(exemplar.isPresent()) {
            return ResponseEntity.ok(exemplar.get());
        } else {
            return ResponseEntity.notFound().build();
        }
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
