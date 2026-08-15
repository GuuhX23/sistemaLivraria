package com.example.sistemadebiblioteca.sistema_biblioteca.service;

import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Exemplar;
import com.example.sistemadebiblioteca.sistema_biblioteca.repositoy.ExemplarRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ExemplarService {

    private final ExemplarRepository exemplarRepository;

    public ExemplarService(ExemplarRepository exemplarRepository) {
        this.exemplarRepository = exemplarRepository;
    }

    public Optional<Exemplar> buscarId(Long id) {
        return exemplarRepository.findById(id);
    }

    public List<Exemplar> listarTodos() {
        return exemplarRepository.findAll();
    }

    public Exemplar salvarExemplar(Exemplar exemplar) {
        return exemplarRepository.save(exemplar);
    }

    public void deletar(Long id) {
        exemplarRepository.deleteById(id);
    }
}
