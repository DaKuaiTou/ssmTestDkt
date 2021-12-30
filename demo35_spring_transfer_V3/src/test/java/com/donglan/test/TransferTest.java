package com.donglan.test;


import com.donglan.controller.AccountController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
* 使用spring的事务管理者来进行事务管理
* 第一种方式：编程式事务，硬编码方式，将spring管理事务的代码写在业务层里面进行事务管理
* */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TransferTest {

    @Autowired
    private AccountController accountController;

    @Test
    public void test(){
        accountController.transfer("张三","李四",100.0);
    }
}
