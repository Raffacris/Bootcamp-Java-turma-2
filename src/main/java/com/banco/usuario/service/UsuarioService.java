package com.banco.usuario.service;

import com.banco.usuario.model.Usuario;
import com.banco.usuario.repository.UsuarioRepository;

import java.sql.SQLException;
import java.util.List;

public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService() throws SQLException {
        repository = new UsuarioRepository();
    }

    public void criarUsuario(String nome, String email) throws SQLException {
        repository.salvar(new Usuario(null, nome, email));
    }

    public List<Usuario> listarUsuarios() throws SQLException {
        return repository.listar();
    }

    public Usuario buscarUsuario(Long id) throws SQLException {
        return repository.buscarPorId(id);
    }

    public void atualizarUsuario(Long id, String nome, String email) throws SQLException {
        repository.atualizar(new Usuario(id, nome, email));
    }

    public void removerUsuario(Long id) throws SQLException {
        repository.remover(id);
    }
}

