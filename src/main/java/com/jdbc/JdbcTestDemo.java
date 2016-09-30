package com.jdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sun.tools.hat.internal.parser.Reader;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.springframework.test.annotation.Rollback;

import java.io.File;
import java.io.FileReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.regex.Pattern;

import static com.sun.tools.javadoc.Main.execute;


/**
 * Created by raoqi on 16/9/28.
 */
public class JdbcTestDemo {

    private String user = "root";
    private String password = "123123";
    private String url = "jdbc:mysql://localhost:3306/RQ";

    @Test
    public void update() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = (Connection) DriverManager.getConnection(url, user, password);

        Statement statement = (Statement) connection.createStatement();

        //String sql = "insert into student(stu_name,stu_gender,stu_score) values(\"textName\",\"man\",111.1);";
        String sql = "update student set stu_name='xxxyyyzzz',stu_gender='xxx', stu_score=99.99  where stu_name='textName'  ";
        int res = statement.executeUpdate(sql);
        System.out.println("影响行数:" + res);

        if (statement != null) statement.close();
        if (connection != null) connection.close();
    }

    @Test
    public void delete() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = (Connection) DriverManager.getConnection(url, user, password);


        String sql = "delete from student where stu_name = ?";
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);

        statement.setString(1, "ttt");


        int res = statement.executeUpdate();
        System.out.println("影响了" + res + "行");

        if (statement != null) statement.close();
        if (connection != null) connection.close();


    }


    @Test
    public void select() throws Exception {

        Connection connection = JdbcUtil.getConnection();

//        Statement statement = (Statement) connection.createStatement();

        String sql = "select * from student WHERE id=?";
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
        statement.setString(1, "19");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("stu_name");
            String gender = resultSet.getString("stu_gender");
            double score = resultSet.getDouble("stu_score");

            System.out.println("id:" + id + " name:" + name + " gender:" + gender + " score:" + score);
        }

        JdbcUtil.close(connection, statement);

    }

    @Test
    public void insertCLOB() throws Exception {

        Connection connection = JdbcUtil.getConnection();


        String sql = "insert into t1(id,content) values(?,?)";
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
        statement.setString(1, "1");

        statement.setString(2, "asdasdasd");
//        statement.setCharacterStream(2,reader,file.length());

        int res = statement.executeUpdate();


        JdbcUtil.close(connection, statement);

    }

    @Test
    public void insertBinary() throws Exception {
        Connection connection = JdbcUtil.getConnection();

        String sql = "insert into t1(id,content2) values(?,?)";
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
        statement.setString(1, "3");

//        statement.setString(2,"asdasdasd");
        statement.setBytes(2, "xxxaasdasd".getBytes());
//        statement.setCharacterStream(2,reader,file.length());

        int res = statement.executeUpdate();

        JdbcUtil.close(connection, statement);

    }

    @Test
    public void batchInsert() throws Exception {
        Connection connection = JdbcUtil.getConnection();

        Statement statement = (Statement) connection.createStatement();
        for (int i = 0; i <= 50; i++) {
            String sql = "insert into t1(id,content) values(" + i + "," + "'i'" + ")";
            statement.addBatch(sql);
        }
        int[] resArray = statement.executeBatch();

        connection.close();
    }

    @Test
    public void batchInsert2() throws Exception {
        Connection connection = JdbcUtil.getConnection();

        PreparedStatement statement = (PreparedStatement) connection.prepareStatement("insert into t1(id,content) values(?,?)");
        for (int i = 51; i <= 100; i++) {
            statement.setString(1,i+"");
            statement.setString(2,i+"");
            statement.addBatch();
        }
        int[] resArray = statement.executeBatch();

        connection.close();
    }

    @Test
    public void testTransaction() throws Exception{
        Connection connection = null;
        try{

            connection = JdbcUtil.getConnection();
            connection.setAutoCommit(false);
            Statement statement = (Statement) connection.createStatement();

            statement.executeUpdate("insert into t1(id,content) values(1,'xxx')");

            int i = 1/0;
            statement.executeUpdate("insert into t1(id,content) values(2,'yyy')");

            connection.commit();
            statement.close();
        } catch (Exception e){

            try{
                connection.rollback();
            } catch (Exception e1){
                e1.printStackTrace();
            }

            e.printStackTrace();
        }

        if(connection != null){
            try {
                connection.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        
    }
}













