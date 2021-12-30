package com.donglan.test;

import com.donglan.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.annotation.Resources;

public class SpringTest {
    @Test
    public void test01(){
        // 1. 直接创建Spring的核心容器，同时指定加载类路径下的xml核心配置文件
        // 在创建核心容器的时候，就已经读取了整个黑犀牛配置问价你，而且就已经创建好了配置问价你里面的所有的bean标签对应的对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 调用核心容器的方法，根据id获取对象
        // 使用接口来接收实现类的对象，也是出于解耦的操作【多态的作用】
        UserService userService = (UserService) applicationContext.getBean("userService");
    }

    /*
    * 测试单例与多例
    * */
    @Test
    public void test02(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService1 = (UserService) applicationContext.getBean("userService02");
        UserService userService2 = (UserService) applicationContext.getBean("userService02");

        System.out.println(userService1 == userService2);

    }

    /*
    * 测试懒加载
    * */
    @Test
    public void test03(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 这一步是默认的，当核心容器创建的时候就把对象创建出来
        UserService userService1 = (UserService) applicationContext.getBean("userService");

        // 这一步是懒加载，当调用getBean方法的时候才会把对象创建出来
        UserService userService2 = (UserService) applicationContext.getBean("userService02");

    }

    /*
    * 测试对象的初始化和销毁时候调用的方法
    * 创建对象的时候进行一些数据的初始化
    * 销毁的时候执行一下数据的备份操作
    * */
    @Test
    public void test04(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 因为是懒加载的原因，所以会在调用getBean方法的时候执行初始化方法
        UserService userService2 = (UserService) applicationContext.getBean("userService02");
        //applicationContext.close();


        // 下边的这个代码不是销毁，只是断掉了指向的引用
        // 实例对象一直都保存在Spring容器中的，引向断掉了，并不意味这容器中的实例对象也会消失
        userService2 = null;
    }

    /*
    * 了解一下Spring的工厂模式
    * */
    @Test
    public void test05(){
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:\\applicationContext.xml");

        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.getUserName();

    }
    @Test
    public void test06(){
        Resource resource = new ClassPathResource("applicationContext.xml");
        // 创建核心容器
        BeanFactory beanFactory = new XmlBeanFactory(resource);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.getUserName();

    }

}















