package com.objectiva.dbconnect;

import cn.hutool.log.StaticLog;

import java.sql.*;

/**
 * @author Willis Bai
 * @title: PostgreSqlJDBCQueryTableDemo
 * @projectName BasicCoreJava
 * @description: query the table data
 * @date 9/28/202110:36 AM
 */
public class PostgreSqlJDBCQueryTableDataDemo {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            connection.setAutoCommit(false);//默认开启自动提交，此处关闭，在下面手动提交
            StaticLog.info("Connect to database successfully");

            statement = connection.createStatement();
            String queryDataSQL = "SELECT * FROM public.t_user_info";
            ResultSet resultSet = statement.executeQuery(queryDataSQL);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("user_name");
                int age = resultSet.getInt("age");
                Date createDate = resultSet.getDate("create_date");
                Timestamp updateDate = resultSet.getTimestamp("update_date");
                StaticLog.info("id: {},name: {},age: {},createDate: {}, updateDate: {}", id, userName, age, createDate, updateDate);
            }

            resultSet.close();
            statement.close();
            connection.close();
            StaticLog.info("Query data to database successfully");
        } catch (Exception e) {
            e.printStackTrace();
            StaticLog.error("Failed to connect to database", e);
        }
    }
}
