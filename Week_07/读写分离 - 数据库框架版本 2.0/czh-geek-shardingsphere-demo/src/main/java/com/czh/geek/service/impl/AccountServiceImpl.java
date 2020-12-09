package com.czh.geek.service.impl;

import com.czh.geek.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Caizh
 * @date 2020/12/9
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void updateAccountBalance(Integer id, Integer balance) {
        String sql = "update account_brief set balance = ? where id = ?";
        jdbcTemplate.update(sql, balance, id);
    }

}
