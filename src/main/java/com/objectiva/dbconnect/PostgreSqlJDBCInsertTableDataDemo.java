package com.objectiva.dbconnect;

import cn.hutool.log.StaticLog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Willis Bai
 * @title: PostgreSqlJDBCInsertDataDemo
 * @projectName BasicCoreJava
 * @description: save data to database
 * @date 9/28/202110:16 AM
 */
public class PostgreSqlJDBCInsertTableDataDemo {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            connection.setAutoCommit(false);//默认开启自动提交，此处关闭，在下面手动提交
            StaticLog.info("Connect to database successfully");

            statement = connection.createStatement();
            String insertDataSQL = "INSERT INTO public.t_user_info (id, user_name, age, create_date, update_date) VALUES(16, 'Lucy', 31, current_timestamp, current_timestamp)";
            statement.executeUpdate(insertDataSQL);
            insertDataSQL = "INSERT INTO public.t_user_info (id, user_name, age, create_date, update_date) VALUES(17, 'Lily', 30, current_timestamp, current_timestamp)";
            statement.executeUpdate(insertDataSQL);
            insertDataSQL = "INSERT INTO public.t_user_info (id, user_name, age, create_date, update_date) VALUES(18, 'Jackson', 32, current_timestamp, current_timestamp)";
            statement.executeUpdate(insertDataSQL);
            connection.commit();

            statement.close();
            connection.close();
            StaticLog.info("Insert data to database successfully");
        } catch (Exception e) {
            e.printStackTrace();
            StaticLog.error("Failed to connect to database", e);
        }
    }
}
