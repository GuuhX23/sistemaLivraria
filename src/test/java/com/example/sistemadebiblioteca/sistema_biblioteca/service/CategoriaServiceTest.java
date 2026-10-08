package com.example.sistemadebiblioteca.sistema_biblioteca.service;

import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Categoria;
import com.example.sistemadebiblioteca.sistema_biblioteca.repositoy.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoriaServiceTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaService categoriaService;

    @Test
    //busacar id
    void deveRetornarUmaCategoriaquandoExistir() {
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNome("Infantil");

        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));

        Categoria resultado = categoriaService.buscarId(1L);

        assertEquals("Infantil", resultado.getNome());
    }

    @Test
    //buscar e lancar um erro
    void deveLancarExcessaoQuandoIdNaoExisti() {
        when(categoriaRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> categoriaService.buscarId(99L));
    }

    @Test
    //listar todos
    void deveListarTodosAsCategorias() {
        Categoria categoria1 = new Categoria();
        categoria1.setId(1L);
        categoria1.setNome("Infantil");

        Categoria categoria2 = new Categoria();
        categoria2.setId(2L);
        categoria2.setNome("Suspense");

        List<Categoria> lista = List.of(categoria1, categoria2);

        when(categoriaRepository.findAll()).thenReturn(lista);

        List<Categoria> resultado = categoriaService.listarTodos();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Infantil", resultado.get(0).getNome());
        assertEquals("Suspense", resultado.get(1).getNome());

    }

    @Test
    //salvar categoria
    void deveSalvarCategoria() {
        Categoria categoriaParaSalvar = new Categoria();
        categoriaParaSalvar.setId(1L);
        categoriaParaSalvar.setNome("Infantil");

        Categoria categoriaSalva = new Categoria();
        categoriaSalva.setId(1L);
        categoriaSalva.setNome("Infantil");

        when(categoriaRepository.save(categoriaParaSalvar)).thenReturn(categoriaSalva);

        Categoria resultado = categoriaService.salvarCategoria(categoriaSalva);

        assertNotNull(resultado);
        assertNotNull(resultado.getId());
        assertEquals(1L, resultado.getId());
        assertEquals("Infantil", resultado.getNome());

    }

    @Test
    //deletar
    void deveChamarDeleteByIdAoDeletar() {
        categoriaService.deletar(1L);

        verify(categoriaRepository).deleteById(1L);
    }

}
