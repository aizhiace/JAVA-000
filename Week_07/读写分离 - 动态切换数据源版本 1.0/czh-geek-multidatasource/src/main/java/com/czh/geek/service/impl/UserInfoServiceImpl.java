package com.czh.geek.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.czh.geek.datasource.CurrDataSource;
import com.czh.geek.datasource.DataSourceNames;
import com.czh.geek.entity.UserInfo;
import com.czh.geek.mapper.UserInfoMapper;
import com.czh.geek.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author Caizh
 * @date 2020/12/2
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Override
    public UserInfo findUserFromPrimary(Integer id) {
        return getById(id);
    }

    @CurrDataSource(name = DataSourceNames.SECOND)
    @Override
    public UserInfo findUserFromSecond(Integer id) {
        return getById(id);
    }

}
