package com.example.spring.data.jpa.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = UserServiceImpl.class)
@EnableTransactionManagement
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testUserService() {
//        System.out.println("userService: " + userService);
        userService.findById(1L);
    }
}
