package com.czh.geek.homework.jdbc;

/**
 * @author Caizh
 * @date 2020/11/18
 */
public class JDBCTest {

    public static void main(String[] args) throws Exception {
        // 1）使用 JDBC 原生接口，实现数据库的增删改查操作。
//        Connection conn = JDBCUtils.getConnection();
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM user_info");
//        //如果有数据，rs.next()返回true
//        while (rs.next()) {
//            System.out.println("姓名：" + rs.getString("name") + "，年龄：" + rs.getInt("age"));
//        }


        // 2）使用事务，PrepareStatement 方式，批处理方式，改进上述操作。
//        Connection conn = JDBCUtils.getConnection();
//
//        conn.setAutoCommit(false);
//
//        List<User> users = new ArrayList<>();
//
//        User user = new User();
//        user.setName("小强");
//        user.setAddress("湖南");
//        user.setAge(8);
//
//        User user2 = new User();
//        user2.setName("小亮");
//        user2.setAddress("湖北");
//        user2.setAge(30);
//
//        users.add(user);
//        users.add(user2);
//
//        UserDAO userDAO = new UserDAO(true);
//        userDAO.batchAddUser(users);
//
//        conn.commit();


        // 3）配置 Hikari 连接池，改进上述操作。
        User user = new User();
        user.setName("小刚");
        user.setAddress("河北");
        user.setAge(18);

        UserDAO userDAO = new UserDAO(false);
        userDAO.addUser(user);
    }

}
