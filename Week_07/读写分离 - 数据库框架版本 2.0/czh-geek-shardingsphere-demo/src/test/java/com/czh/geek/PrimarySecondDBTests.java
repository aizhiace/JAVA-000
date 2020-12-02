package com.czh.geek;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Slf4j
@SpringBootTest
class PrimarySecondDBTests {

    @Resource
    private DataSource dataSource;

    /**
     * 读写分离，主库写，从库读
     * 同一线程且同一数据库连接内，如有写入操作，以后的读操作均从主库读取，用于保证数据一致性
     */
    @Test
    public void readWrite() {
        Connection con = null;
        try {
            con = dataSource.getConnection();
            Statement st = con.createStatement();

            //从从库读数据
            ResultSet rs = st.executeQuery("select * from user_info");
            while (rs.next()) {
                log.info(rs.getString("id") + "|" + rs.getString("name"));
            }

            //写入主库
            st.executeUpdate("insert into user_info(id,name) values(null,'王五')");

            //从主库读数据
            rs = st.executeQuery("select * from user_info");
            while (rs.next()) {
                log.info(rs.getString(1) + "|" + rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            JdbcUtil.close(con);
        }
    }

    /**
     * 读写分离，强制主库路由
     */
    @Test
    public void hintPrimaryRouteOnly() {
        Connection con = null;
        try {
            con = dataSource.getConnection();
            Statement st = con.createStatement();
            HintManager hintManager = HintManager.getInstance();
            //主库路由
            hintManager.setMasterRouteOnly();

            //从主库读数据
            ResultSet rs = st.executeQuery("select * from user_info");
            while (rs.next()) {
                log.info(rs.getString(1) + "|" + rs.getString(2));
            }
            hintManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            JdbcUtil.close(con);
        }
    }

}
