package com.czh.geek;

import com.czh.geek.service.PayService;
import org.apache.commons.collections4.MapUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Caizh
 * @date 2020/12/9
 */
@SpringBootTest
public class TransactionTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PayService payService;

    @Test
    public void testPay() {
        Integer accountId = 1;
        Integer orderId = 1;

        String orderSql = "select * from order_master_brief where id = ?";
        Map<String, Object> orderMap = jdbcTemplate.queryForMap(orderSql, orderId);

        if (MapUtils.isEmpty(orderMap)) {
            throw new RuntimeException("未查询到订单");
        }

        String accountSql = "select * from account_brief where id = ?";
        Map<String, Object> accountMap = jdbcTemplate.queryForMap(accountSql, accountId);

        if (MapUtils.isEmpty(accountMap)) {
            throw new RuntimeException("未查询到账户");
        }

        Integer balance = (Integer) accountMap.get("balance");
        Integer toUpdateBalance = balance - 100;

        payService.pay(orderId, accountId, toUpdateBalance);

        Map<String, Object> accountMapUpdated = jdbcTemplate.queryForMap(accountSql, accountId);
        Integer updatedBalance = (Integer) accountMapUpdated.get("balance");

        Map<String, Object> orderMapUpdated = jdbcTemplate.queryForMap(orderSql, orderId);
        Integer orderStatus = (Integer) orderMapUpdated.get("order_status");

        assertEquals(2, orderStatus);
        assertEquals(toUpdateBalance, updatedBalance);
    }

    @Test
    public void testPayThrow() {
        Integer accountId = 1;
        Integer orderId = 1;

        String orderSql = "select * from order_master_brief where id = ?";
        Map<String, Object> orderMap = jdbcTemplate.queryForMap(orderSql, orderId);

        if (MapUtils.isEmpty(orderMap)) {
            throw new RuntimeException("未查询到订单");
        }

        String accountSql = "select * from account_brief where id = ?";
        Map<String, Object> accountMap = jdbcTemplate.queryForMap(accountSql, accountId);

        if (MapUtils.isEmpty(accountMap)) {
            throw new RuntimeException("未查询到账户");
        }

        Integer balance = (Integer) accountMap.get("balance");
        Integer toUpdateBalance = balance - 100;

        payService.payThrow(orderId, accountId, toUpdateBalance);
    }

}
