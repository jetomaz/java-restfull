package br.com.tomazinformatica.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Vamos trabalhar com um conex„o simples de JDBC
public class DbConfig {

    // Criado como static para que n√£o seja necessario instanciar
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/notas_db", "root", "root");
    }
}