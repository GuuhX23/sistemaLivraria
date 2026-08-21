package com.example.sistemadebiblioteca.sistema_biblioteca.service;

import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Livro;
import com.example.sistemadebiblioteca.sistema_biblioteca.repositoy.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;


@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro buscarId(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Livro nao encontrado"));
    }

    public Livro salvarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }



}
