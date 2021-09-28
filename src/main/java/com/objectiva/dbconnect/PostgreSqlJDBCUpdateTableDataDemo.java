package com.objectiva.dbconnect;

import cn.hutool.log.StaticLog;

import java.sql.*;

/**
 * @author Willis Bai
 * @title: PostgreSqlJDBCUpdateTableDemo
 * @projectName BasicCoreJava
 * @description: update the data
 * @date 9/28/202111:00 AM
 */
public class PostgreSqlJDBCUpdateTableDataDemo {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            connection.setAutoCommit(false);//默认开启自动提交，此处关闭，在下面手动提交
            StaticLog.info("Connect to database successfully");

            statement = connection.createStatement();
            String updateDataSQL = "UPDATE public.t_user_info SET user_name = 'updated_user', update_date = current_timestamp where ID =3";
            statement.executeUpdate(updateDataSQL);
            connection.commit();

            statement.close();
            connection.close();
            StaticLog.info("Update data to database successfully");
        } catch (Exception e) {
            e.printStackTrace();
            StaticLog.error("Failed to connect to database", e);
        }
    }
}
