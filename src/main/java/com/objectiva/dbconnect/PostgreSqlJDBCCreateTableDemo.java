package com.objectiva.dbconnect;

import cn.hutool.log.StaticLog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Willis Bai
 * @title: PostgreSqlJDBCCreateTableDemo
 * @projectName BasicCoreJava
 * @description: create table
 * @date 9/27/20215:24 PM
 */
public class PostgreSqlJDBCCreateTableDemo {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            StaticLog.info("Connect to database successfully");
            statement = connection.createStatement();

            StringBuffer createTableSQL = new StringBuffer();
            createTableSQL.append("CREATE TABLE public.t_user_info ( ");
            createTableSQL.append("id int4 NOT NULL, ");
            createTableSQL.append("user_name varchar(20), ");
            createTableSQL.append("age int4, ");
            createTableSQL.append("create_date timestamp, ");
            createTableSQL.append("update_date timestamp, ");
            createTableSQL.append("CONSTRAINT t_user_info_pkey PRIMARY KEY (id) ");
            createTableSQL.append(") ");
            statement.executeUpdate(createTableSQL.toString());
            StaticLog.info("Create table successfully");
        } catch (ClassNotFoundException | SQLException e) {
            StaticLog.error("Failed to connect to database", e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                StaticLog.error("Close the statement or connection failed", e);
            }

        }
    }
}
