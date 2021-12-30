package com.donglan;

import com.donglan.mapper.AccountMapper;
import com.donglan.mapper.UserMapper;
import com.donglan.pojo.Account;
import com.donglan.pojo.User;
import com.donglan.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SqlSessionFactpryUtilTest {

   @Test
    public void test1(){
       SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
       UserMapper mapper = sqlSession.getMapper(UserMapper.class);

       User user = new User();
       user.setUsername("孙强");
       user.setAddress("上海");
       user.setSex("女");
       user.setBirthday(new Date());

       mapper.insertUser(user);

      System.out.println(user.getUid());
       SqlSessionFactoryUtil.commitAndClose(sqlSession);

   }

   @Test
   public void test2(){
      SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);


      mapper.deleteUserByUid(19);

      SqlSessionFactoryUtil.commitAndClose(sqlSession);

   }

   @Test
   public void test3(){
      SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);


      User user = mapper.selectUserByUid(18);

      user.setSex("男");

      mapper.updateUser(user);

      SqlSessionFactoryUtil.commitAndClose(sqlSession);

   }

}
