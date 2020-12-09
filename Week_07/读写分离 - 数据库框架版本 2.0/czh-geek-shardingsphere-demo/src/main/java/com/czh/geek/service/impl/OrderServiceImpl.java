package com.czh.geek.service.impl;

import com.czh.geek.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Caizh
 * @date 2020/12/9
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void updateOrderStatus(Integer id, Integer status) {
        String sql = "update order_master_brief set order_status = ? where id = ?";
        jdbcTemplate.update(sql, status, id);
    }

}
