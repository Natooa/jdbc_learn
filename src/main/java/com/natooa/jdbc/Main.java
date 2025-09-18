package com.natooa.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;

public class Main {
    private static final DatabaseConnection databaseConnection = new DatabaseConnection();
    private static final String GET_ALL = "SELECT * FROM dish";
    private static final String DELETE_ = "DELETE FROM dish WHERE dish_id = ?";
    public static void main(String[] args) {
        String INSERT_NEW = "INSERT INTO dish VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try{
            Connection connection = databaseConnection.getConnection();

            preparedStatement = connection.prepareStatement(DELETE_);
            preparedStatement.setInt(1, 2);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet res = preparedStatement.executeQuery();
            while(res.next()){
                int id = res.getInt("dish_id");
                String title = res.getString("title");
                String description = res.getString("description");
                float rating = res.getFloat("rating");
                boolean published =  res.getBoolean("published");
                Date date = res.getDate("created");
                byte[] icon = res.getBytes("icon");

                System.out.println(id + " " + title + " " + description + " " + rating + " " + published + " " + date + " " + icon.length);
            }

//            preparedStatement.setInt(1, 2);
//            preparedStatement.setString(2, "inserted title");
//            preparedStatement.setString(3, "Inserted Descc");
//            preparedStatement.setFloat(4, 0.2f);
//            preparedStatement.setBoolean(5, true);
//            preparedStatement.setDate(6, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
//            preparedStatement.setBlob(7, new FileInputStream("smile.png"));

//            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
