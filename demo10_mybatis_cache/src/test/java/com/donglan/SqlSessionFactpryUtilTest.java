package com.donglan;

import com.donglan.mapper.UserMapper;
import com.donglan.pojo.User;
import com.donglan.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SqlSessionFactpryUtilTest {

    @Test
    public void testFindAllUsers1(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 我们来测试  验证一级缓存的存在

        // 第一次查询用户数据，是从数据库中获取的
        List<User> userList1 = mapper.findAllUsers();
        printList(userList1);

        // 一级缓存的清除，执行增删改操作
        //mapper.insertUser(getUser());
        //sqlSession.close();
        sqlSession.clearCache();
        System.out.println("---------------------------------");

        // 第二次查询用户数据，应该是从一级缓存中获取(不会执行sql语句，去数据库中查询数据了)
        List<User> userList2 = mapper.findAllUsers();
        printList(userList2);

        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }


    @Test
    public void testFindAllUsers2(){
        // 我们来测试  二级缓存的存在
        // 以下三个sqlSession对象都是由同一个SqlSessionFactory创建出来的
        SqlSession sqlSession1 = SqlSessionFactoryUtil.getSqlSession();
        SqlSession sqlSession2 = SqlSessionFactoryUtil.getSqlSession();
        SqlSession sqlSession3 = SqlSessionFactoryUtil.getSqlSession();

        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);

        List<User> userList1 = mapper1.findAllUsers();
        printList(userList1);
        sqlSession1.close();// sqlSession1对象查询结束，需要关闭，否则无法使用二级缓存

        System.out.println("————————————————————————————————————");

        /*List<User> userList2 = mapper2.findAllUsers();
        printList(userList2);*/
        // 第二个SqlSession对象进行增删改操作
        mapper2.insertUser(getUser());
        //sqlSession2.close();

        sqlSession2.close();// sqlSession1对象查询结束，需要关闭，否则无法使用二级缓存

        System.out.println("————————————————————————————————————");

        List<User> userList3 = mapper3.findAllUsers();
        printList(userList3);


        //SqlSessionFactoryUtil.commitAndClose(sqlSession1);
        //SqlSessionFactoryUtil.commitAndClose(sqlSession2);
        //SqlSessionFactoryUtil.commitAndClose(sqlSession3);
    }



    public void printList(List<User> userList){
        for (User user : userList) {
            System.out.println(user);
        }

    }

    public User getUser(){
        User user = new User();
        user.setUsername("武文斌");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("深圳");
        return user;
    }
}
