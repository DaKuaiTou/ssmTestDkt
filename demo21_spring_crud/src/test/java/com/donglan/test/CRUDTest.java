package com.donglan.test;

import com.donglan.pojo.User;
import com.donglan.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class CRUDTest {

    @Test
    public void test01() throws SQLException {
        // 创建Spring的核心容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        // 获取UserService对象
        UserService userService = (UserService) applicationContext.getBean("userService");
        // 通过id查询用户
        User user = userService.findById(1);
        System.out.println(user);
    }

    @Test
    public void test02(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        DataSource dataSource  = (DataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource);
    }

    @Test
    public void test03() throws SQLException {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123465");
        user.setNickname("张三三");
        // 创建Spring的核心容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        // 获取UserService对象
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.addUser(user);
    }

    @Test
    public void test04() throws SQLException {
        // 创建Spring的核心容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        // 获取UserService对象
        UserService userService = (UserService) applicationContext.getBean("userService");

        User user = userService.findById(2);
        user.setPassword("555");
        userService.updateUser(user);
    }

    @Test
    public void test05() throws SQLException {
        // 创建Spring的核心容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        // 获取UserService对象
        UserService userService = (UserService) applicationContext.getBean("userService");

        userService.deleteUserById(2);
    }











}
