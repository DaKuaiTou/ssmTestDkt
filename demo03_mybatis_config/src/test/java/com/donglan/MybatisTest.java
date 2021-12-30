package com.donglan;

import com.donglan.mapper.UserMapper;
import com.donglan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void testFindAllUser() throws IOException {
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
        InputStream in = Resources.getResourceAsStream("SqlMapperConfig.xml");
        // 2. 根据获得核心配置文件的输入流，来创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        // 3. 使用factoryBuilder对象去加载字节输入流对象in
        // 通过build方法用来解析xml配置，解析完成之后，会返回sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = factoryBuilder.build(in);// 使用了建造者模式

        // 4. 获得mybatis核心配置文件，我们就可以通过核心配置文件创建sqlSession对象
        //  那打破了SqlSession对象之后，就相当于拿到了connection对象，可以操作sql语句的
        SqlSession sqlSession = sqlSessionFactory.openSession();// 使用了工厂模式

        // 5. 执行sql语句
        //List<User> userList = sqlSession.selectList("hello.findAllUser"); // 传统方式
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);// 动态代理模式
        // 调用mapper代理对象的findAllUser方法，进行查询操作
        List<User> userList = mapper.findAllUsers();

        for (User user : userList) {
            System.out.println(user);
        }

        // 6. 关闭资源
        sqlSession.close();
        in.close();
    }
}
