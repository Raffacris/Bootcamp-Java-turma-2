package com.banco.usuario.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.banco.usuario.model.Usuario;
import com.banco.usuario.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return service.criarUsuario(usuario.getNome(), usuario.getEmail());
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return service.buscarUsuario(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return service.atualizarUsuario(id, usuario.getNome(), usuario.getEmail());
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.removerUsuario(id);
    }
}