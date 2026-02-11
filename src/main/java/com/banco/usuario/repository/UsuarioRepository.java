package com.banco.usuario.repository;

import com.banco.usuario.model.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    private static final String URL = "jdbc:h2:mem:testdb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    private Connection connection;

    public UsuarioRepository() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        criarTabela();
    }

    private void criarTabela() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS usuario (
                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                    nome VARCHAR(255),
                    email VARCHAR(255)
                )
                """;

        Statement stmt = connection.createStatement();
        stmt.execute(sql);
    }

    public void salvar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (nome, email) VALUES (?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.executeUpdate();
    }

    public List<Usuario> listar() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        ResultSet rs = connection.createStatement().executeQuery(sql);

        while (rs.next()) {
            lista.add(new Usuario(
                    rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("email")
            ));
        }

        return lista;
    }

    public Usuario buscarPorId(Long id) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new Usuario(
                    rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("email")
            );
        }
        return null;
    }

    public void atualizar(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET nome = ?, email = ? WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.setLong(3, usuario.getId());
        stmt.executeUpdate();
    }

    public void remover(Long id) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        stmt.executeUpdate();
    }
}
