package com.donglan.test;

import com.donglan.controller.UserController;
import com.donglan.mapper.UserMapper;
import com.donglan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/*
* 单元测试方法其是就是在Junit框架中的main方法中执行的
*
* 之前我们都是自己创建的ApplicationContext，然后点击测试运行，其实就是在Junit调用的方法来运行起来的
*
* 我们现在要让Junit直接帮我们创建核心容器：使用spring整合Junit
*   1. 引入依赖
*   2. junit的依赖版本必须是4.12以上
*   3. 添加注解@Runwith即可
*   4. 主要让Junit能过够知道去加载哪个配置文件或者加载哪个和配置类
*
* */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class mybatisTest {

    // 对我们需要的成员属性进行依赖注入即可
    @Autowired
    private UserController userController;

    @Test
    public void test01() throws IOException {
        // 1. 创建Builder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 2. 加载核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        // 3. 通过builder来构建factory对象，一个项目中一般就一个工厂对象【核心对象】
        SqlSessionFactory factory = builder.build(inputStream);
        // 4. 执行sql语句，我们就应该创建一个sqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 5. 通过sqlSession对象来创建Dao层的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 6. 通过代理对象调用dao层接口中的方法
        List<User> list = mapper.findAllUser();
        System.out.println(list);
        // 7. 关闭资源
        sqlSession.close();
        inputStream.close();
    }


    @Test
    public void test02(){
        // 1. 从spring的核心容器中获取，userMapper的代理对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        // 2. 从spring的核心容器中来获取
        UserMapper userMapper1 = (UserMapper) applicationContext.getBean("userMapper");
        UserMapper userMapper2 = (UserMapper) applicationContext.getBean("userMapper");
        System.out.println(userMapper1 == userMapper2);// true
        List<User> allUser = userMapper1.findAllUser();
        System.out.println(allUser);
    }

    @Test
    public void test03(){
/*        // 1. 从spring的核心容器中获取，userMapper的代理对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        // 2. 从spring的核心容器中来获取
        UserController userController = (UserController) applicationContext.getBean("userController");*/

        List<User> all = userController.findAll();
        System.out.println(all);
    }

    @Test
    public void test04(){
/*        // 1. 从spring的核心容器中获取，userMapper的代理对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        // 2. 从spring的核心容器中来获取
        UserController userController = (UserController) applicationContext.getBean("userController");*/

        User user = new User();
        user.setUsername("冬澜");
        user.setPassword("123654");
        user.setNickname("冬冬");
        userController.addUser(user);
    }

}





















