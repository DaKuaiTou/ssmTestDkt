package com.donglan;

import com.donglan.mapper.UserMapper;
import com.donglan.pojo.User;
import com.donglan.pojo.UserInfo;
import com.donglan.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SqlSessionFactoryUtilTest {
    @Test
    public void testFindUserTotal(){
        // 1. 创建SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        // 2. 创建UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3. 调用mapper代理对象，执行查询所有用户数据的方法
        Long userTotal = mapper.findUserTotal();
        System.out.println("查询的所有的用户总数量为："+userTotal);
        // 4. 关闭资源，提交事务
        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }

    @Test
    public void testFindById(){
        // 1. 创建SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        // 2. 创建UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3. 调用mapper代理对象，执行查询所有用户数据的方法
        User user = mapper.findById(1);
        System.out.println(user);
        // 4. 关闭资源，提交事务
        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }

    @Test
    public void testFindByUsername(){
        // 1. 创建SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        // 2. 创建UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3. 调用mapper代理对象，执行查询所有用户数据的方法
        Map map = mapper.findByUsername("张三三");
        Set keys = map.keySet();
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()){
            String key = (String) iterator.next();
            System.out.println(key+":"+map.get(key));
        }
        // 4. 关闭资源，提交事务
        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }

    @Test
    public void testFindAllUser1(){
        // 1. 创建SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        // 2. 创建UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3. 调用mapper代理对象，执行查询所有用户数据的方法
        List<User> userList = mapper.findAllUsers1();
        System.out.println(userList);
        // 4. 关闭资源，提交事务
        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }

    @Test
    public void testFindAllUser2(){
        // 1. 创建SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        // 2. 创建UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3. 调用mapper代理对象，执行查询所有用户数据的方法
        List<Map<String, Object>> mapList = mapper.findAllUsers2();
        for (Map<String, Object> map : mapList) {
            Set keys = map.keySet();
            Iterator iterator = keys.iterator();
            while (iterator.hasNext()){
                String key = (String) iterator.next();
                System.out.println(key+":"+map.get(key));
            }
        }

        // 4. 关闭资源，提交事务
        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }

    @Test
    public void testFindAllUserInfo(){
        // 1. 创建SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        // 2. 创建UserMapper的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3. 调用mapper代理对象，执行查询所有用户数据的方法
        List<UserInfo> userInfoList = mapper.findAllUserInfo();
        System.out.println(userInfoList);


        // 4. 关闭资源，提交事务
        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }
}
