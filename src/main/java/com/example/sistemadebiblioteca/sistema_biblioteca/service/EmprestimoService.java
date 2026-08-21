package com.example.sistemadebiblioteca.sistema_biblioteca.service;

import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Emprestimo;
import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Exemplar;
import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Usuario;
import com.example.sistemadebiblioteca.sistema_biblioteca.repositoy.EmprestimoRepository;
import com.example.sistemadebiblioteca.sistema_biblioteca.repositoy.ExemplarRepository;
import com.example.sistemadebiblioteca.sistema_biblioteca.repositoy.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ExemplarRepository exemplarRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, ExemplarRepository exemplarRepository, UsuarioRepository usuarioRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.exemplarRepository = exemplarRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Emprestimo buscarId(Long id) {
        return emprestimoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Emprestimo nao encontrado"));
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo salvarEmprestimo(Long usuarioId, Long exemplarId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new NoSuchElementException("Usuario nao encontrado"));

        Exemplar exemplar = exemplarRepository.findById(exemplarId)
                .orElseThrow(() -> new NoSuchElementException("Exemplar nao encontrado"));

        Emprestimo novoEmprestimo = new Emprestimo();
        novoEmprestimo.setUsuario(usuario);
        novoEmprestimo.setExemplar(exemplar);

        return emprestimoRepository.save(novoEmprestimo);
    }

    public void deletar(Long id) {
        emprestimoRepository.deleteById(id);
    }


}
