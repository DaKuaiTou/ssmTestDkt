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
    public void testFindAccountUserByAid(){
       SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
       AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
       Account account = mapper.selectAccountByAid(1);
      System.out.println(account.getMoney());
       System.out.println("------------------------------------");
       System.out.println(account.getUser());
   }

   @Test
   public void testFindUserAccountListByUid(){
      SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      User user = mapper.findUserByUid2(1);
      System.out.println(user.getUsername());
      System.out.println("-------------------------------");
      System.out.println(user.getAccountList());
   }
}
