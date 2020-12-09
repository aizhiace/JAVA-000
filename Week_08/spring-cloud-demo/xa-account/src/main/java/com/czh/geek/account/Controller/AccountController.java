package com.czh.geek.account.Controller;

import com.czh.geek.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caizh
 * @date 2020/12/9
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/account/balance/update")
    public void updateAccountBalance(Integer id, Integer balance) {
        accountService.updateAccountBalance(id, balance);
    }

}
