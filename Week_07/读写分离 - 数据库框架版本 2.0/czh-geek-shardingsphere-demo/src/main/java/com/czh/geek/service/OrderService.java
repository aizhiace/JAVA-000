package com.czh.geek.service;

/**
 * @author Caizh
 * @date 2020/12/9
 */
public interface OrderService {

    /**
     * 修改订单状态
     *
     * @param id     订单id
     * @param status 订单状态：1-未支付，2-已支付
     */
    void updateOrderStatus(Integer id, Integer status);

}
