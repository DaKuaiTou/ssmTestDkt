package com.donglan;

import com.donglan.mapper.RoleMapper;
import com.donglan.mapper.UserMapper;
import com.donglan.pojo.Role;
import com.donglan.pojo.User;
import com.donglan.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SqlSessionFactpryUtilTest {

    @Test
    public void testFindRoleUserListByRid(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Role role = mapper.findRoleUserListByRid(4);
        System.out.println(role);
    }

    @Test
    public void testFindUserRoleListByUid(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserRoleListByUid(1);
        System.out.println(user);
    }
}
