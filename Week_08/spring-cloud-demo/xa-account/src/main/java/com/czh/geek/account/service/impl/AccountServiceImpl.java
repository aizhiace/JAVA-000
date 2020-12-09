package com.czh.geek.account.service.impl;

import com.czh.geek.account.service.AccountService;
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
public class AccountServiceImpl implements AccountService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    @Override
    public void updateAccountBalance(Integer id, Integer balance) {
        String sql = "update account_brief set balance = ? where id = ?";
        jdbcTemplate.update(sql, balance, id);
    }

}
