package com.objectiva.dbconnect;

import cn.hutool.log.StaticLog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Java通过JDBC连接到PostgreSQL数据库
 * @author willis.bai
 */
public class PostgreSqlJDBCConnDemo {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        } catch (ClassNotFoundException | SQLException e) {
            StaticLog.error("Failed to connect to database", e);
        }
        StaticLog.info("Connect to database successfully: {}", conn);
    }

}
