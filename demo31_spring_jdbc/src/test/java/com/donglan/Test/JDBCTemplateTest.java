package com.donglan.Test;

import com.donglan.dao.UserDao;
import com.donglan.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class JDBCTemplateTest {
    // 使用JDBC模板API来进行相关的增删改查

    @Test
    public void save(){
        // 创建数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("rootroot");

        // 创建JDBC模板
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        // 操作数据库
        String sql = "insert into user(username,password,nickname) values(?,?,?)";
        jdbcTemplate.update(sql,"李琳","123123","琳琳");


    }

    @Autowired
    private UserDao userDao2;

    @Test
    public void test01(){
        User user = userDao2.findUserById(6);
        System.out.println(user);
    }
}
