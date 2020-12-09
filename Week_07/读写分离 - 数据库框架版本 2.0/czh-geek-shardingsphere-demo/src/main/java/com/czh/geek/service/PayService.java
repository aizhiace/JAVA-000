package com.czh.geek.service;

/**
 * @author Caizh
 * @date 2020/12/9
 */
public interface PayService {

    /**
     * 支付成功，修改订单状态成功，修改账户余额成功
     *
     * @param orderId   订单id
     * @param accountId 账户id
     * @param balance   余额
     */
    void pay(Integer orderId, Integer accountId, Integer balance);

    /**
     * 支付失败，修改订单状态回滚，修改账户余额回滚
     *
     * @param orderId   订单id
     * @param accountId 账户id
     * @param balance   余额
     */
    void payThrow(Integer orderId, Integer accountId, Integer balance);

}
