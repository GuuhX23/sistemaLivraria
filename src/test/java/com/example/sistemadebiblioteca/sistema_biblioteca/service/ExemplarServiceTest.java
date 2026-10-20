package com.example.sistemadebiblioteca.sistema_biblioteca.service;

import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Exemplar;
import com.example.sistemadebiblioteca.sistema_biblioteca.repositoy.ExemplarRepository;
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
class ExemplarServiceTest {

    @Mock
    private ExemplarRepository exemplarRepository;

    @InjectMocks
    private ExemplarService exemplarService;

    @Test
    void deveRetornarExemplarQuandoExistir() {
        Exemplar exemplar = new Exemplar();
        exemplar.setId(1L);
        exemplar.setCodigoBarras("123");

        when(exemplarRepository.findById(1L)).thenReturn(Optional.of(exemplar));

        Exemplar resultado = exemplarService.buscarId(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
    }

    @Test
    void deveLancarUmaExcessaoQaudnonaoExistirId() {
        when(exemplarRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> exemplarService.buscarId(99L));
    }

    @Test
    void deveListarTodosOsExemplares() {
        Exemplar exemplar1 = new Exemplar();
        exemplar1.setId(1L);
        exemplar1.setCodigoBarras("123");

        Exemplar exemplar2 = new Exemplar();
        exemplar2.setId(2L);
        exemplar2.setCodigoBarras("456");

        List<Exemplar> lista = List.of(exemplar1,exemplar2);

        when(exemplarRepository.findAll()).thenReturn(lista);

        List<Exemplar> resultado = exemplarService.listarTodos();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("123", resultado.get(0).getCodigoBarras());
        assertEquals("456", resultado.get(1).getCodigoBarras());

    }

    @Test
    void deveChamarDeleteByIdAoDeletar() {
        exemplarService.deletar(1L);

        verify(exemplarRepository).deleteById(1L);
    }




}
