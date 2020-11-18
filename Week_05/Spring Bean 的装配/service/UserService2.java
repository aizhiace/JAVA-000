package com.czh.geek.homework.framework.service;

import com.czh.geek.homework.bean.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Caizh
 * @date 2020/11/18
 */
@Component
public class UserService2 {

    @Autowired
    private User2 user2;

    public User2 getUser2() {
        return user2;
    }

    @Autowired
    public void setUser2(User2 user2) {
        this.user2 = user2;
    }

    public UserService2() {
        System.out.println("UserService2无参构造。。。。。。。。。");
    }

//    @Autowired
//    public UserService2(User2 user2) {
//        System.out.println("UserService2带参构造++++++++++++++");
//        this.user2 = user2;
//    }

}
