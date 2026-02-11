package com.banco.usuario.model;

import java.util.Objects;

public class Usuario {

    private Long id;
    private String nome;
    private String email;

    
    protected Usuario() {}

    
    public Usuario(Long id, String nome, String email) {
        setId(id);
        setNome(nome);
        setEmail(email);
    }

    
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    
    public void setId(Long id) {
        if (id != null && id <= 0) {
            throw new IllegalArgumentException("ID deve ser maior que zero.");
        }
        this.id = id;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.nome = nome.trim();
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido.");
        }
        this.email = email.trim().toLowerCase();
    }

    

    public void atualizarDados(String nome, String email) {
        setNome(nome);
        setEmail(email);
    }

   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}