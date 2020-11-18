package com.czh.geek.homework.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Caizh
 * @date 2020/11/18
 */
public class UserDAO {

    /**
     * true-使用JDBCUtils，false-使用DataSourceUtils
     */
    private boolean useJDBCUtils;

    public UserDAO(boolean useJDBCUtils) {
        this.useJDBCUtils = useJDBCUtils;
    }

    //增加
    public void addUser(User user) throws SQLException {
        //获取连接
        Connection conn = getConnection();

        //sql
        String sql = "INSERT INTO user_info(id,name,address,age) values(?,?,?,?)";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql);

        //传参
        ptmt.setString(1, null);
        ptmt.setString(2, user.getName());
        ptmt.setString(3, user.getAddress());
        ptmt.setInt(4, user.getAge());

        //执行
        ptmt.execute();
    }

    public void batchAddUser(List<User> users) throws SQLException {
        //获取连接
        Connection conn = getConnection();

        //sql
        String sql = "INSERT INTO user_info(id,name,address,age) values(?,?,?,?)";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql);

        for (User user : users) {
            //传参
            ptmt.setString(1, null);
            ptmt.setString(2, user.getName());
            ptmt.setString(3, user.getAddress());
            ptmt.setInt(4, user.getAge());

            ptmt.addBatch();
        }

        //执行
        ptmt.executeBatch();
    }

    public void updateUser(User user) throws SQLException {
        //获取连接
        Connection conn = getConnection();

        //sql, 每行加空格
        String sql = "UPDATE user_info" +
                " set name=?, address=?, age=?" +
                " where id=?";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql);

        //传参
        ptmt.setString(1, null);
        ptmt.setString(2, user.getName());
        ptmt.setString(3, user.getAddress());
        ptmt.setInt(4, user.getAge());

        //执行
        ptmt.execute();
    }

    public void deleteUser(Integer id) throws SQLException {
        //获取连接
        Connection conn = getConnection();

        //sql, 每行加空格
        String sql = "delete from user_info where id=?";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt = conn.prepareStatement(sql);

        //传参
        ptmt.setInt(1, id);

        //执行
        ptmt.execute();
    }

    public List<User> getUsers() throws SQLException {
        //获取连接
        Connection conn = getConnection();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id,name,address,age FROM user_info");

        List<User> users = new ArrayList<User>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAddress(rs.getString("address"));
            user.setAge(rs.getInt("age"));

            users.add(user);
        }
        return users;
    }

    public User getUser(Integer id) throws SQLException {
        User user = null;

        //获取连接
        Connection conn = getConnection();

        //sql, 每行加空格
        String sql = "SELECT id,name,address,age FROM user_info where id=?";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //传参
        ptmt.setInt(1, id);
        //执行
        ResultSet rs = ptmt.executeQuery();
        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAddress(rs.getString("address"));
            user.setAge(rs.getInt("age"));
        }
        return user;
    }

    private Connection getConnection() {
        Connection conn;
        if (useJDBCUtils) {
            conn = JDBCUtils.getConnection();
        } else {
            conn = DataSourceUtils.getConnection();
        }
        return conn;
    }

}
