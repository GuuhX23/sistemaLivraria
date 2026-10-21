package com.example.sistemadebiblioteca.sistema_biblioteca.service;

import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Categoria;
import com.example.sistemadebiblioteca.sistema_biblioteca.repository.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void deveAtualizarCategoriaComSucesso() {
        // 1. ARRANGE (Preparação dos dados e cenários)
        Long idExistente = 1L;

        // Objeto vindo na requisição (dados novos)
        Categoria categoriaParaAtualizar = new Categoria(null, "Livros de Ficção");

        // Objeto existente no banco de dados antes da alteração
        Categoria categoriaExistente = new Categoria(idExistente, "Livros");

        // Objeto retornado após salvar a alteração
        Categoria categoriaSalva = new Categoria(idExistente, "Livros de Ficção");

        // Ensinar os Mocks como devem responder
        when(categoriaRepository.findById(idExistente))
                .thenReturn(Optional.of(categoriaExistente));

        when(categoriaRepository.save(any(Categoria.class)))
                .thenReturn(categoriaSalva);

        // 2. ACT (Execução da ação a ser testada)
        Categoria resultado = categoriaService.atualizar(idExistente, categoriaParaAtualizar);

        // 3. ASSERT (Verificações dos resultants)
        assertNotNull(resultado);
        assertEquals(idExistente, resultado.getId());
        assertEquals("Livros de Ficção", resultado.getNome());

        // Verificar se os métodos do repositório foram chamados exatamente 1 vez
        verify(categoriaRepository, times(1)).findById(idExistente);
        verify(categoriaRepository, times(1)).save(any(Categoria.class));
    }


}
