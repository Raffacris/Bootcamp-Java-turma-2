package com.banco.usuario.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/seubanco";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    private ConexaoFactory() {
        // impede instanciação
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados.", e);
        }
    }
}
