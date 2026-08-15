package com.example.sistemadebiblioteca.sistema_biblioteca.controller;


import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Usuario;
import com.example.sistemadebiblioteca.sistema_biblioteca.service.UsuarioService;
import jakarta.persistence.NamedStoredProcedureQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public Optional<Usuario> buscarId(@PathVariable Long id) {
        return usuarioService.buscarId(id);
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @PostMapping
    public Usuario salvarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.salvarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
    }
}
