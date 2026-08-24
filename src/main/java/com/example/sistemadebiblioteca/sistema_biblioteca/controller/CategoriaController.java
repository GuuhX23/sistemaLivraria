package com.example.sistemadebiblioteca.sistema_biblioteca.controller;

import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Categoria;
import com.example.sistemadebiblioteca.sistema_biblioteca.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarId(@PathVariable Long id) {
        Categoria categoria = categoriaService.buscarId(id);
        return ResponseEntity.ok(categoria);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodos() {
       List<Categoria> categorias = categoriaService.listarTodos();
       return ResponseEntity.ok(categorias);
    }

    @PostMapping
    public ResponseEntity<Categoria> salvarCategoria(@Valid @RequestBody Categoria categoria) {
        Categoria categoriaSalva = categoriaService.salvarCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
