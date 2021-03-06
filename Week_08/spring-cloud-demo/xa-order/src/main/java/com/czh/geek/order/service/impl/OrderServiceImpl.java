package com.czh.geek.order.service.impl;

import com.czh.geek.order.service.OrderService;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Caizh
 * @date 2020/12/9
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    @Override
    public void updateOrderStatus(Integer id, Integer status) {
        String sql = "update order_master_brief set order_status = ? where id = ?";
        jdbcTemplate.update(sql, status, id);
    }

}
