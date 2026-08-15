package com.example.sistemadebiblioteca.sistema_biblioteca.controller;

import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Exemplar;
import com.example.sistemadebiblioteca.sistema_biblioteca.service.ExemplarService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<Exemplar>> listarTodos() {
        List<Exemplar> exemplares = exemplarService.listarTodos();
        return ResponseEntity.ok(exemplares);
    }

    @PostMapping
    public ResponseEntity<Exemplar> salvarExemplar(@RequestBody Exemplar exemplar) {
        Exemplar exemplarSalvo = exemplarService.salvarExemplar(exemplar);
        return ResponseEntity.status(HttpStatus.CREATED).body(exemplarSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        exemplarService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
