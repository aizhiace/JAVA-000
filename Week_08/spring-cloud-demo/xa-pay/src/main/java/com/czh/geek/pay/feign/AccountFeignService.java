package com.czh.geek.pay.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Caizh
 * @date 2020/12/9
 */
@FeignClient(value = "account-service")
public interface AccountFeignService {

    @RequestMapping(value = "/account/balance/update", method = RequestMethod.GET)
    void updateAccountBalance(@RequestParam(value = "id") Integer id, @RequestParam(value = "balance") Integer balance);

}
