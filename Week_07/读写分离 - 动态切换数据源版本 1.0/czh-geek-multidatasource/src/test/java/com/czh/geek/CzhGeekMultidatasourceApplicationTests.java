package com.czh.geek;

import com.czh.geek.entity.UserInfo;
import com.czh.geek.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class CzhGeekMultidatasourceApplicationTests {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void queryFromMultiDataSource() {
        UserInfo userInfo = userInfoService.findUserFromPrimary(1);
        log.info("查询主库，获取到的用户信息为：{}", userInfo);

        UserInfo userInfo2 = userInfoService.findUserFromSecond(1);
        log.info("查询从库，获取到的用户信息为：{}", userInfo2);
    }

}
