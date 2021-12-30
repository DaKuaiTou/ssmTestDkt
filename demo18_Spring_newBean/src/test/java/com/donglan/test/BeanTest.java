package com.donglan.test;

import com.donglan.service.UserService;
import com.donglan.utils.DruidUtil;
import com.donglan.utils.DruidUtil2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class BeanTest {
    /*
    * 方式一：无参构造方法
    * */
    @Test
    public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
    }
    /*
    * 方式二：静态工厂的方法\
    *
    * */
    @Test
    public void test02(){

        // DataSource dataSource = DruidUtil.getDataSource();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource);
    }
    /*
    * 方式三：实例化工厂方式
    * */
    @Test
    public void test03(){

        /*DruidUtil2 druidUtil2 = new DruidUtil2();
        DataSource dataSource = druidUtil2.getDataSource();*/


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource2");
        System.out.println(dataSource);
    }

}







