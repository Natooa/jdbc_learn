package com.natooa.jdbc;

import java.sql.*;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_learn";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Natooa1407%";

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement =  connection.createStatement()) {
//            statement.execute("INSERT INTO animal (animal_name, anime_desc) VALUES ('name', 'description');");

//            int  res = statement.executeUpdate("UPDATE animal SET animal_name = 'New name' WHERE animal_id = 1");
//            System.out.println(res);

//            ResultSet res = statement.executeQuery("SELECT * FROM animal");

//            statement.addBatch("INSERT INTO animal (animal_name, anime_desc) VALUES ('lion', 'king of animal'), ('monkey', 'bibizyana'), ('tiger', 'bars');");
//            statement.executeBatch();
//            statement.clearBatch();
//            boolean status = statement.isClosed();
//            System.out.println(status);

            statement.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
