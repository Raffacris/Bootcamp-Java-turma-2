package com.banco.usuario.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.usuario.model.Usuario;
import com.banco.usuario.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    // O Spring injeta automaticamente o UsuarioService
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // Criar usuário
    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return service.criarUsuario(usuario.getNome(), usuario.getEmail());
    }

    // Listar todos os usuários
    /**
     * @return
     */
    @GetMapping
    public List<Usuario> listar() {
        return service.listarUsuarios();
    }

    // Buscar usuário por ID
    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return service.buscarUsuario(id);
    }

    // Atualizar usuário
    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return service.atualizarUsuario(id, usuario.getNome(), usuario.getEmail());
    }

    // Remover usuário
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.removerUsuario(id);
    }
}