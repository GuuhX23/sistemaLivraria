package com.example.sistemadebiblioteca.sistema_biblioteca.service;

import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Livro;
import com.example.sistemadebiblioteca.sistema_biblioteca.entities.Usuario;
import com.example.sistemadebiblioteca.sistema_biblioteca.repositoy.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

   public Usuario buscarId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuario nao encontrado"));
   }

   public List<Usuario> listarTodos() {
        return  usuarioRepository.findAll();
   }

   public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
   }

   public void deletar(Long id) {
        usuarioRepository.deleteById(id);
   }


}
