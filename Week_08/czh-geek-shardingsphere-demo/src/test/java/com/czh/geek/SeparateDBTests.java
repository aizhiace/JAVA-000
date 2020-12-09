package com.czh.geek;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Slf4j
@SpringBootTest
class SeparateDBTests {

    @Resource
    private DataSource dataSource;

    /**
     * 数据分片
     * user_info在同一个库里分表(user_info_0,user_info_1)
     * dept_info分库
     */
    @Test
    public void fragmentation() {
        Connection con = null;
        try {
            con = dataSource.getConnection();
            con.setAutoCommit(false);
            Statement st = con.createStatement();

            //插入ds0.user_info_0表
            st.executeUpdate("insert into user_info(id,name,age) values(1,'张三', 30)");
            //插入ds0.user_info_1表
            st.executeUpdate("insert into user_info(id,name,age) values(2,'李四', 31)");

            //插入ds0.dept_info表
            st.executeUpdate("insert into dept_info(id,name) values(1,'部门1')");
            //插入ds1.dept_info表
            st.executeUpdate("insert into dept_info(id,name) values(2,'部门2')");

            ResultSet rs = st.executeQuery("select id,name from user_info where id in(1,2)");
            while (rs.next()) {
                log.info("id={},name={}", rs.getString("id"), rs.getString("name"));
            }

            rs = st.executeQuery("select id,name from dept_info where id in(1,2)");
            while (rs.next()) {
                log.info("id={},name={}", rs.getString("id"), rs.getString("name"));
            }

            con.commit();
        } catch (Exception e) {
//            JdbcUtil.rollback(con);
            e.printStackTrace();
        } finally {
//            JdbcUtil.close(con);
        }
    }

}
