package com.banco.usuario.service;

import com.banco.usuario.model.Usuario;
import com.banco.usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario criarUsuario(String nome, String email) {
        Usuario usuario = new Usuario(null, nome, email);
        return repository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }

    public Usuario buscarUsuario(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
    }

    public Usuario atualizarUsuario(Long id, String nome, String email) {
        Usuario usuario = buscarUsuario(id);
        usuario.atualizarDados(nome, email);
        return repository.save(usuario);
    }

    public void removerUsuario(Long id) {
        repository.deleteById(id);
    }
}
