package com.natooa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();

        String query = "SELECT * FROM users WHERE user_id = 2";
        try {
            Statement statement = databaseConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));

                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
