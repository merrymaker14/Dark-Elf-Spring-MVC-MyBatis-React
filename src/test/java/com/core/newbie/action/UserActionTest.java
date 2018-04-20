package com.core.newbie.action;

import com.alibaba.fastjson.JSON;
import com.core.newbie.model.User;
import com.core.newbie.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
//@WebAppConfiguration
public class UserActionTest {
    private static final Logger logger = Logger.getLogger(UserActionTest.class);
    private UserService userService;

    @Autowired
    public void setUserService(final UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    @Test
    public void test1() {
        final User user = new User();
        user.setId(1);
        user.setIsAdmin(true);
        user.setPassword("001");
        user.setLogin("admin");
//        userService.save(user);
        logger.info(JSON.toJSON(user));
    }

    @Test
    public void test2() {
        final User user = userService.getUserById(1);
        logger.info(JSON.toJSON(user));
    }

    @Test
    public void test3() {
        final User user = new User();
        user.setId(2);
        user.setIsAdmin(false);
        user.setPassword("002");
        user.setLogin("user");
//        userService.save(user);
        logger.info(JSON.toJSON(user));
    }
}
