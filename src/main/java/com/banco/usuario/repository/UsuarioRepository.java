package com.banco.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.usuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}