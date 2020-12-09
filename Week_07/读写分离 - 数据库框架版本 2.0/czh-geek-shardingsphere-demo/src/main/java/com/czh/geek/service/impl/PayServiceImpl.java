package com.czh.geek.service.impl;

import com.czh.geek.service.AccountService;
import com.czh.geek.service.OrderService;
import com.czh.geek.service.PayService;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Caizh
 * @date 2020/12/9
 */
@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private AccountService accountService;

    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    @Override
    public void pay(Integer orderId, Integer accountId, Integer balance) {
        orderService.updateOrderStatus(orderId, 2);
        accountService.updateAccountBalance(accountId, balance);
    }

    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    @Override
    public void payThrow(Integer orderId, Integer accountId, Integer balance) {
        orderService.updateOrderStatus(orderId, 2);
        accountService.updateAccountBalance(accountId, balance);
        throw new RuntimeException("支付失败");
    }

}
