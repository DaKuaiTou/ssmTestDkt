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
    public void testFindUserListByAddress(){
        // 1. 创建SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        // 2. 创建UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3. 调用mapper代理对象，执行查询所有用户数据的方法

        List<User> userList = mapper.findUserListByAddress("上海");
        for (User user : userList) {
            System.out.println(user);
        }
        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }

    @Test
    public void testFindUserListByAddressAndSex(){
        // 1. 创建SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        // 2. 创建UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3. 调用mapper代理对象，执行查询所有用户数据的方法
        User user = new User();
        user.setSex("男");
        // user.setAddress("上海");
        List<User> userList = mapper.findUserListByAddressAndSex(user);
        for (User user1 : userList) {
            System.out.println(user1);
        }
        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }

    @Test
    public void testFindUserListByAddressAndSex2(){
        // 1. 创建SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        // 2. 创建UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3. 调用mapper代理对象，执行查询所有用户数据的方法
        User user = new User();
        //user.setSex("男");
        //user.setAddress("上海");
        List<User> userList = mapper.findUserListByAddressAndSex2(user);
        for (User user1 : userList) {
            System.out.println(user1);
        }
        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }

    @Test
    public void testUpdateUser(){
        // 1. 创建SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        // 2. 创建UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3. 调用mapper代理对象，执行查询所有用户数据的方法

        User user = mapper.findUserById(1);

        user.setUsername("张三");

        mapper.updateUser(user);

        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }

    @Test
    public void testDeleteByIds(){
        // 1. 创建SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        // 2. 创建UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3. 调用mapper代理对象，执行查询所有用户数据的方法

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(13);
        ids.add(14);
        ids.add(15);
        mapper.deleteByIds(ids);


        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }

    @Test
    public void testFindUserListByAddressAndSex3(){
        // 1. 创建SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        // 2. 创建UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3. 调用mapper代理对象，执行查询所有用户数据的方法
        User user = new User();
        user.setSex("男");
        user.setAddress("上海");
        List<User> userList = mapper.findUserListByAddressAndSex3(user);
        for (User user1 : userList) {
            System.out.println(user1);
        }
        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }
}
