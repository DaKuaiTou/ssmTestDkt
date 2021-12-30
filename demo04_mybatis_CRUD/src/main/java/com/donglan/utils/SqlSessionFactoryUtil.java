package com.donglan.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/*
* 类加载的时候就需要创建出来一个SqlSessionFactory对象
* 我们还需要声明一个方法，用来返回SqlSession对象
* 每次执行sql语句的sqlSession对象不能是同一个
* */
public class SqlSessionFactoryUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            InputStream in = Resources.getResourceAsStream("SqlMapperConfig.xml");
            // 2. 根据获得核心配置文件的输入流，来创建SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            // 3. 使用factoryBuilder对象去加载字节输入流对象in
            // 通过build方法用来解析xml配置，解析完成之后，会返回sqlSessionFactory对象
            sqlSessionFactory = factoryBuilder.build(in);// 使用了建造者模式

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * 创建SqlSession对象，使用该方法返回SqlSessio对象
    * */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    /*
    * 提交事务且关闭资源
    * */
    public static void commitAndClose(SqlSession sqlSession){
        sqlSession.commit();
        sqlSession.close();
    }

    /*
    * 回滚事务且关闭资源
    * */
    public static void rollbackAndClose(SqlSession sqlSession){
        sqlSession.rollback();
        sqlSession.close();
    }

}
