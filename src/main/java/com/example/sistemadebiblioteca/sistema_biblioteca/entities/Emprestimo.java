package com.example.sistemadebiblioteca.sistema_biblioteca.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_emprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @NotNull(message = "O usuario e obrigatorio")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "exemplar_id")
    @NotNull(message = "O exemplar e obrigatorio")
    private Exemplar exemplar;

    @NotNull(message = "A data de emprestimo e obrigatorio")
    private Date dateEmprestimo;

    @NotNull(message = "A data prevista e obrigatorio")
    private Date dataDevolucaoPrevista;

    @NotNull(message = "A data de devolucao e obrigatorio")
    private Date dataDevolucaoReal;

    public Emprestimo() {}

    public Emprestimo(Long id, Usuario usuario, Date dateEmprestimo, Date dataDevolucaoPrevista, Date dataDevolucaoReal) {
        this.id = id;
        this.usuario = usuario;
        this.dateEmprestimo = dateEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDateEmprestimo() {
        return dateEmprestimo;
    }

    public void setDateEmprestimo(Date dateEmprestimo) {
        this.dateEmprestimo = dateEmprestimo;
    }

    public Date getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(Date dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public Date getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public void setDataDevolucaoReal(Date dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}

