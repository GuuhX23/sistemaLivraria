package com.example.sistemadebiblioteca.sistema_biblioteca.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jdk.jshell.Snippet;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_exemplar")
public class Exemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    @NotNull(message = "O livro e obrigatorio")
    private Livro livro;

    @NotBlank(message = "O codigo de barras e obrigatorio")
    private String CodigoBarras;

    @NotBlank(message = "O status e obrigatorio")
    private String status;

   @OneToMany(mappedBy = "exemplar")
   private Set<Emprestimo> emprestimos = new HashSet<>();

    public Exemplar() {}

    public Exemplar(Long id, Livro livro, String codigoBarras, String status) {
        this.id = id;
        this.livro = livro;
        CodigoBarras = codigoBarras;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getCodigoBarras() {
        return CodigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        CodigoBarras = codigoBarras;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Exemplar exemplar = (Exemplar) o;
        return Objects.equals(id, exemplar.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
