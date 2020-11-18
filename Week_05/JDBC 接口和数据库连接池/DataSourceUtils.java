package com.czh.geek.homework.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Caizh
 * @date 2020/11/18
 */
public class DataSourceUtils {

    public static final String URL = "jdbc:mysql://localhost:3306/test_db?characterEncoding=utf-8&allowMultiQueries=true";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    private static Connection conn = null;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);
        config.addDataSourceProperty("connectionTimeout", "1000"); // 连接超时：1秒
        config.addDataSourceProperty("idleTimeout", "60000"); // 空闲超时：60秒
        config.addDataSourceProperty("maximumPoolSize", "10"); // 最大连接数：10

        DataSource ds = new HikariDataSource(config);

        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return conn;
    }

}
