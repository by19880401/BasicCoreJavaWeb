package com.objectiva.dbconnect;

import cn.hutool.log.StaticLog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author Willis Bai
 * @title: PostgreSqlJDBCDeleteTableDataDemo
 * @projectName BasicCoreJava
 * @description: delete the data
 * @date 9/28/202112:17 PM
 */
public class PostgreSqlJDBCDeleteTableDataDemo {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            connection.setAutoCommit(false);//默认开启自动提交，此处关闭，在下面手动提交
            StaticLog.info("Connect to database successfully");

            statement = connection.createStatement();
            String delDataSQL = "DELETE FROM public.t_user_info where ID IN (4,5,6)";
            statement.executeUpdate(delDataSQL);
            connection.commit();

            statement.close();
            connection.close();
            StaticLog.info("Delete data to database successfully");
        } catch (Exception e) {
            e.printStackTrace();
            StaticLog.error("Failed to connect to database", e);
        }
    }
}
