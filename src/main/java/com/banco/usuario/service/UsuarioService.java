package com.banco.usuario.service;

import com.banco.usuario.model.Usuario;
import com.banco.usuario.repository.UsuarioRepository;

import java.sql.SQLException;
import java.util.List;

public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService() {
        try {
            this.repository = new UsuarioRepository();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inicializar o repositório.", e);
        }
    }

   
    public Usuario criarUsuario(String nome, String email) {
        try {
            Usuario usuario = new Usuario(null, nome, email);
            repository.salvar(usuario);
            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar usuário.", e);
        }
    }

    
    public List<Usuario> listarUsuarios() {
        try {
            return repository.listar();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar usuários.", e);
        }
    }

        public Usuario buscarUsuario(Long id) {
        try {
            Usuario usuario = repository.buscarPorId(id);

            if (usuario == null) {
                throw new IllegalArgumentException("Usuário não encontrado.");
            }

            return usuario;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário.", e);
        }
    }

   
    public Usuario atualizarUsuario(Long id, String nome, String email) {

        Usuario usuarioExistente = buscarUsuario(id);

        usuarioExistente.atualizarDados(nome, email);

        try {
            repository.atualizar(usuarioExistente);
            return usuarioExistente;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar usuário.", e);
        }
    }

   
    public void removerUsuario(Long id) {

        buscarUsuario(id); // Garante que existe

        try {
            repository.remover(id);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover usuário.", e);
        }
    }
}

