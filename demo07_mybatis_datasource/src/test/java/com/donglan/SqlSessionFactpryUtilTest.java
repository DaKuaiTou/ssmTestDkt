package com.donglan;

import com.donglan.mapper.UserMapper;
import com.donglan.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
}
