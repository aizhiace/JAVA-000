package com.czh.geek.order.controller;

import com.czh.geek.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caizh
 * @date 2020/12/9
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/status/update")
    public void updateOrderStatus(Integer id, Integer status) {
        orderService.updateOrderStatus(id, status);
    }

}
