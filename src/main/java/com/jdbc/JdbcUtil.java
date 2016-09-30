package com.jdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by raoqi on 16/9/29.
 */
public class JdbcUtil {
    static private String url = "jdbc:mysql://localhost:3306/RQ";
    static private String user = "root";
    static private String password = "123123";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");



        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static Connection getConnection(){
        try{
            Connection connection = (Connection) DriverManager.getConnection(url,user,password);
            return connection;
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void close(Connection connection, Statement statement){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }

        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }

        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }

        if(resultSet != null){
            try {
                statement.close();
            } catch (SQLException e){
                e.printStackTrace();

            }
        }
    }


}













