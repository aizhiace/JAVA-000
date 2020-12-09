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
class SeparateDBAndTableTests {

    @Resource
    private DataSource dataSource;

    /**
     * 数据分片
     */
    @Test
    public void fragmentation() {
        Connection con = null;
        try {
            con = dataSource.getConnection();
            con.setAutoCommit(false);
            Statement st = con.createStatement();

            for (int i = 1; i <= 32; i++) {
                String sql = "insert into order_master_brief(id,no,order_status,customer_id) values(" + i + "," + 1000 + i + ",1," + i + ")";
                st.executeUpdate(sql);
            }

            ResultSet rs = st.executeQuery("select id,no,customer_id from order_master_brief");
            while (rs.next()) {
                log.info("id={},no={},customer_id={}", rs.getInt("id"), rs.getString("no"), rs.getInt("customer_id"));
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
