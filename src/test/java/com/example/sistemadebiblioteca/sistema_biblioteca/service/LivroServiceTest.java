package com.example.sistemadebiblioteca.sistema_biblioteca.service;

import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Livro;
import com.example.sistemadebiblioteca.sistema_biblioteca.repositoy.LivroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LivroServiceTest {

    @Mock
    private LivroRepository livroRepository;

    @InjectMocks
    private LivroService livroService;

    @Test
    //buscarId
    void deveRetornarLivroQuandoIdExistir() {
        Livro livro = new Livro();
        livro.setId(1L);
        livro.setTitulo("Dom Casmurro");

        when(livroRepository.findById(1L)).thenReturn(Optional.of(livro));

        Livro resultado = livroService.buscarId(1L);
        assertEquals("Dom Casmurro", resultado.getTitulo());

    }

    @Test
    //buscarId e lanca um erro
    void deveLancarExcecaoQuandoIdNaoExistir() {
        when(livroRepository.findById(99L)).thenReturn(Optional.empty());
        //Optional.empty() simula o cenario
        // em que o registtro/categoria com id 99 nao foi encontrado
        assertThrows(NoSuchElementException.class, () -> livroService.buscarId(99L));
    }

    @Test
    //lista todos
    void deveListarTodosOsLivros() {
       Livro livro1 = new Livro();
       livro1.setId(1L);
       livro1.setTitulo("Dom Casmurro");

       Livro livro2 = new Livro();
       livro2.setId(2L);
       livro2.setTitulo("Memorias Postumas de Bras Cubas");

       List<Livro> lista = List.of(livro1, livro2);

       when(livroRepository.findAll()).thenReturn(lista);

       List<Livro> resultado = livroService.listarTodos();

       assertNotNull(resultado);
       assertEquals(2, resultado.size());
       assertEquals("Dom Casmurro", resultado.get(0).getTitulo());
       assertEquals("Memorias Postumas de Bras Cubas", resultado.get(1).getTitulo());
    }

    @Test
    //salvar livro
    void deveSalvarLivro() {
        Livro livroParaSalvar = new Livro();
        livroParaSalvar.setId(1L);
        livroParaSalvar.setTitulo("Dom Casmurro");

        Livro livroSalvo = new Livro();
        livroSalvo.setId(1L);
        livroSalvo.setTitulo("Dom Casmurro");

        when(livroRepository.save(livroParaSalvar)).thenReturn(livroSalvo);

        Livro resultado = livroService.salvarLivro(livroParaSalvar);

        assertNotNull(resultado);
        assertNotNull(resultado.getId());
        assertEquals(1L, resultado.getId());
        assertEquals("Dom Casmurro", resultado.getTitulo());


    }


    @Test
    //deletar
    void deveChamarDeleteByIdAoDeletar() {
        // Act: executa o método que você quer testar
        livroService.deletar(1L);

        // Assert: verifica se o mock foi "usado" da forma esperada
        verify(livroRepository).deleteById(1L);
    }
}
