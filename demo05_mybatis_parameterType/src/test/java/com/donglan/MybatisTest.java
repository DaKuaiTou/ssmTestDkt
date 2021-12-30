package com.donglan;

import com.donglan.mapper.UserMapper;
import com.donglan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    private InputStream in = null;
    private SqlSession sqlSession = null;
    private UserMapper mapper = null;

    @Before
    public void init() throws IOException {
        /*
         * 步骤：
         *   1.让程序运行的时候去加载mybatis的核心配置文件
         *       - 配置了连接数据库的信息
         *       - 加载了映射文件，封装了JDBC
         *
         *   2. mybatis的核心对象是SqlSessionFactory，如果要使用mybatis的话，就必须要拿到SqlSessionFactory核心对象
         *
         *   3. 如果要想获得核心对象，我么还需要准备一个核心配置文件，那么我们可以使用SqlSessionFactoryBuilder对象来创建
         * */

        // 1. 将核心配置文件SqlMapperConfig.xml转换为字节输入流
        // InputStream in = MybatisTest.class.getClassLoader().getResourceAsStream("SqlMapperConfig.xml");
        in = Resources.getResourceAsStream("SqlMapperConfig.xml");
        // 2. 根据获得核心配置文件的输入流，来创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        // 3. 使用factoryBuilder对象去加载字节输入流对象in
        // 通过build方法用来解析xml配置，解析完成之后，会返回sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = factoryBuilder.build(in);// 使用了建造者模式

        // 4. 获得mybatis核心配置文件，我们就可以通过核心配置文件创建sqlSession对象
        //  那打破了SqlSession对象之后，就相当于拿到了connection对象，可以操作sql语句的
        sqlSession = sqlSessionFactory.openSession();// 使用了工厂模式

        // 5. 执行sql语句
        //List<User> userList = sqlSession.selectList("hello.findAllUser"); // 传统方式
        mapper = sqlSession.getMapper(UserMapper.class);// 动态代理模式
    }

    /*
     * 获取所有用户数据
     * */
    @Test
    public void testFindAllUser() throws IOException {

        // 调用mapper代理对象的findAllUser方法，进行查询操作
        List<User> userList = mapper.findAllUsers();

        for (User user : userList) {
            System.out.println(user);
        }

    }




    /*
    * 添加新用户
    * */
    @Test
    public void testAddUser(){
        // 直接调用动态代理对象的addUser方法，来添加用户
        User user = new User(null,"张武","男",new Date(),"深圳");
        mapper.addUser(user);

        // 需求：当用户新增完毕之后，要获取该用户的id：目的是为了在以后的多表操作中，设计到关联业务的使用
        System.out.println("新增用户的id："+user.getId());
    }

    /*
    * 根据用户id查询用户
    * */
    @Test
    public void testFindUserById(){
        User user = mapper.findUserById(8);
        System.out.println(user);
    }

    /*
    * 更新用户
    * */
    @Test
    public void testUpdateUser(){
        User user = mapper.findUserById(7);
        user.setUsername("王大庆");
        user.setSex("男");

        mapper.updateUser(user);
    }

    /*
    * 根据用户id，删除用户
    * */
    @Test
    public void testDeleteUser(){
        mapper.deleteUser(8);
    }


    /*
    * 模糊查询【方式一】
    * */
    @Test
    public void testSearchUserByUsername1(){
        List<User> userList = mapper.searchUserByUsername1("%张%");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /*
     * 模糊查询【方式二】
     * */
    @Test
    public void testSearchUserByUsername2(){
        List<User> userList = mapper.searchUserByUsername2("张");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /*
     * 模糊查询【方式三】
     * */
    @Test
    public void testSearchUserByUsername3(){
        List<User> userList = mapper.searchUserByUsername3("张");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /*
     * 根据用户名称查询用户
     * */
    @Test
    public void testFindUserByUsername(){
        User user = mapper.findUserByUsername("张三");
        System.out.println(user);
    }











    @After
    public void destroy() throws IOException {

        // 提交事务【我们通过在日志中的观察，发现开启了事务，那么，在执行完增删改的操作之后，需要手动提交】
        sqlSession.commit();

        // 6. 关闭资源
        sqlSession.close();
        in.close();

    }
}
