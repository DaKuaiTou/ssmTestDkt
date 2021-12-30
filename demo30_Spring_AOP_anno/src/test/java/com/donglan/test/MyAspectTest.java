package com.donglan.test;


import com.donglan.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Spring.xml")
public class MyAspectTest {

    @Autowired
    private UserService userService;

    @Test
    public void test01(){
        userService.add();
    }

    @Test
    public void test02(){
        userService.deleteById(1);
    }

    @Test
    public void test03(){
        userService.update();
    }

    @Test
    public void test04(){
        userService.query();
    }


}
