package com.example.sistemadebiblioteca.sistema_biblioteca.controller;

import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Emprestimo;
import com.example.sistemadebiblioteca.sistema_biblioteca.service.EmprestimoService;
import com.example.sistemadebiblioteca.sistema_biblioteca.service.ExemplarService;
import com.example.sistemadebiblioteca.sistema_biblioteca.service.UsuarioService;
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
    public Optional<Emprestimo> buscarId(@PathVariable Long id) {
        return emprestimoService.buscarId(id);
    }

    @GetMapping
    public List<Emprestimo> listarTodos() {
        return emprestimoService.listarTodos();
    }

    @PostMapping
    public Emprestimo salvarEmprestimo(@RequestParam Long usuarioId, @RequestParam Long exemplarId) {
        return emprestimoService.salvarEmprestimo(usuarioId, exemplarId);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        emprestimoService.deletar(id);
    }


}
