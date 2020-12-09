package com.czh.geek.pay.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Caizh
 * @date 2020/12/9
 */
@FeignClient(value = "order-service")
public interface OrderFeignService {

    @RequestMapping(value = "/order/status/update", method = RequestMethod.GET)
    void updateOrderStatus(@RequestParam(value = "id") Integer id, @RequestParam(value = "status") Integer status);

}
