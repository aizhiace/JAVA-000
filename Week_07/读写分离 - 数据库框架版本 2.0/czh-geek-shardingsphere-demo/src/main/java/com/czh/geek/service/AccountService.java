package com.czh.geek.service;

/**
 * @author Caizh
 * @date 2020/12/9
 */
public interface AccountService {

    /**
     * 修改账户余额
     *
     * @param id      账户id
     * @param balance 余额
     */
    void updateAccountBalance(Integer id, Integer balance);

}
