package br.com.tomazinformatica.config;

public class DbConfig {

    // Criado como static para que não seja necessario instanciar
    public static Connection getConnection() throws SQLException, ClassnotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/notas_db", "root", "root");
    }
}