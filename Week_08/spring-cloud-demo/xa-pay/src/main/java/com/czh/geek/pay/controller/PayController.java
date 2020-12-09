package com.czh.geek.pay.controller;

import com.czh.geek.pay.feign.AccountFeignService;
import com.czh.geek.pay.feign.OrderFeignService;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caizh
 * @date 2020/12/9
 */
@RestController
public class PayController {

    @Autowired
    private AccountFeignService accountFeignService;

    @Autowired
    private OrderFeignService orderFeignService;

    @RequestMapping(value = "/pay")
    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public void pay(Integer orderId, Integer accountId, Integer balance) {
        orderFeignService.updateOrderStatus(orderId, 2);
        accountFeignService.updateAccountBalance(accountId, balance);
    }

    @RequestMapping(value = "/payThrow")
    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public void payThrow(Integer orderId, Integer accountId, Integer balance) {
        orderFeignService.updateOrderStatus(orderId, 2);
        accountFeignService.updateAccountBalance(accountId, balance);
        throw new RuntimeException("支付失败");
    }

}
