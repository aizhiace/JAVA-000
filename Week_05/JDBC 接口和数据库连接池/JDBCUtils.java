package com.czh.geek.homework.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Caizh
 * @date 2020/11/18
 */
public class JDBCUtils {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/test_db?characterEncoding=utf-8&allowMultiQueries=true";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    private static Connection conn = null;

    static {
        try {
            //1.加载驱动程序
            Class.forName(DRIVER);
            //2. 获得数据库连接
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return conn;
    }

}
