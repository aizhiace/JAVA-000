package com.czh.geek.homework.framework.wire;

import com.czh.geek.homework.bean.User;
import com.czh.geek.homework.framework.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Caizh
 * @date 2020/11/18
 */
@ImportResource(locations = {"classpath:context.xml"})
@Configuration
public class WireConfig {

    @Bean
    public User user(){
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        user.setAddress("北京");
        return user;
    }

    @Bean
    public UserService userService(User user){
        UserService userService = new UserService();
        userService.setUser(user);
        return userService;
    }

}
