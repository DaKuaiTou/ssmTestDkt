package com.donglan;

import com.donglan.mapper.UserMapper;
import com.donglan.pojo.QueryUser;
import com.donglan.pojo.User;
import com.donglan.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlSessionFactpryUtilTest {
    @Test
    public void testFindAllUsers(){
        // 1. 创建SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        // 2. 创建UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3. 调用mapper代理对象，执行查询所有用户数据的方法
        System.out.println(mapper.findAllUsers());
        // 4. 关闭资源，提交事务
        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }

    @Test
    public void testUpdateUser(){
        // 1. 创建SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        // 2. 创建UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3. 调用mapper代理对象，执行查询所有用户数据的方法
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("username","张三三");
        map.put("id",1);
        mapper.updateUserByMap(map);
        // 4. 关闭资源，提交事务
        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }

    @Test
    public void testSearchUserByUsernameAndAddress1(){
        // 1. 创建SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        // 2. 创建UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3. 调用mapper代理对象，执行查询所有用户数据的方法
        User user = mapper.searchuserByUsernameAndAddress1("张三三", "深圳");
        System.out.println(user);
        // 4. 关闭资源，提交事务
        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }

    @Test
    public void testSearchUserByUsernameAndAddress2(){
        // 1. 创建SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        // 2. 创建UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3. 调用mapper代理对象，执行查询所有用户数据的方法
        User user = mapper.searchuserByUsernameAndAddress2("张三三", "深圳");
        System.out.println(user);
        // 4. 关闭资源，提交事务
        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }

    @Test
    public void testSearchByCondition(){
        // 1. 创建SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        // 2. 创建UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3. 调用mapper代理对象，执行查询所有用户数据的方法
        User user = new User();
        user.setSex("男");
        user.setAddress("北京");
        QueryUser queryUser = new QueryUser(1L,2,user);
        List<User> userList = mapper.searchByCondition(queryUser);
        System.out.println(userList);
        // 4. 关闭资源，提交事务
        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }
}
