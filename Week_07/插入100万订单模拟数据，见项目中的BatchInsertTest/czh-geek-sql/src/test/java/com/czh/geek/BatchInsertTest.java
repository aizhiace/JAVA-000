package com.czh.geek;

import com.czh.geek.bean.OrderMasterBrief;
import com.czh.geek.mapper.OrderMasterBriefMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 各种方式比较批量插入100万条数据，执行速度如下：
 * 原生jdbc > jdbcTemplate > mybatis > 存储过程循环insert
 *
 * @author Caizh
 * @date 2020/12/2
 */
@Slf4j
@SpringBootTest
public class BatchInsertTest {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private OrderMasterBriefMapper orderMasterBriefMapper;

    /**
     * 原生jdbc
     * 插入100万条数据：使用原生jdbc批量插入，耗时：7262毫秒
     */
    @Test
    public void jdbcInsert() throws SQLException {
        List<OrderMasterBrief> orderMasterBriefs = getDeptInfos();

        String sql = "insert into order_master_brief(no) values(?)";

        Connection conn = DriverManager.getConnection(url, username, password);

        conn.setAutoCommit(false);

        PreparedStatement prep = conn.prepareStatement(sql);

        for (OrderMasterBrief orderMasterBrief : orderMasterBriefs) {
            prep.setString(1, orderMasterBrief.getNo());
            prep.addBatch();
        }

        long begin = System.currentTimeMillis();
        prep.executeBatch();
        conn.commit();
        long end = System.currentTimeMillis();
        conn.close();

        log.info("使用原生jdbc批量插入，耗时：{}毫秒", end - begin);
    }

    /**
     * jdbcTemplate
     * 插入100万条数据：使用jdbcTemplate批量插入，耗时：11017毫秒
     */
    @Test
    public void jdbcTemplateInsert() {
        List<Object[]> deptInfos = getDeptInfoArrays();

        String sql = "insert into order_master_brief(no) values(?)";

        long begin = System.currentTimeMillis();

        jdbcTemplate.batchUpdate(sql, deptInfos);

        long end = System.currentTimeMillis();

        log.info("使用jdbcTemplate批量插入，耗时：{}毫秒", end - begin);
    }

    /**
     * mybatis
     * 插入100万条数据：使用mybatis批量插入，耗时：21688毫秒
     */
    @Test
    public void mybatisInsert() {
        List<OrderMasterBrief> orderMasterBriefs = getDeptInfos();

        long begin = System.currentTimeMillis();
        orderMasterBriefMapper.batchInsert(orderMasterBriefs);
        long end = System.currentTimeMillis();

        log.info("使用mybatis批量插入，耗时：{}毫秒", end - begin);
    }

    private List<Object[]> getDeptInfoArrays() {
        int size = 1000000;
        List<Object[]> deptInfos = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            Object[] deptInfo = new Object[]{"A" + i};
            deptInfos.add(deptInfo);
        }

        return deptInfos;
    }

    private List<OrderMasterBrief> getDeptInfos() {
        int size = 1000000;
        List<OrderMasterBrief> orderMasterBriefs = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            OrderMasterBrief orderMasterBrief = new OrderMasterBrief();
            orderMasterBrief.setNo("B" + i);
            orderMasterBriefs.add(orderMasterBrief);
        }

        return orderMasterBriefs;
    }

    // mysql存储过程循环insert，插入100万条数据：51410毫秒
//    drop procedure if exists batchInsert;
//    delimiter //
//    create procedure batchInsert(in size int)
//    begin
//        declare num int;
//        start transaction;
//        set num=0;
//        while num < size do
//            insert into order_master_brief(no) values(concat('C',num));
//            set num=num+1;
//        end while;
//        commit;
//    end //

}
