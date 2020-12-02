package com.czh.geek.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.czh.geek.entity.UserInfo;

/**
 * @author Caizh
 * @date 2020/12/2
 */
public interface UserInfoService extends IService<UserInfo> {

    UserInfo findUserFromPrimary(Integer id);

    UserInfo findUserFromSecond(Integer id);

}
