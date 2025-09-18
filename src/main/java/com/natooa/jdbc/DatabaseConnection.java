package com.natooa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_learn";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Natooa1407%";

    private Connection connection;

    public DatabaseConnection() {
        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
