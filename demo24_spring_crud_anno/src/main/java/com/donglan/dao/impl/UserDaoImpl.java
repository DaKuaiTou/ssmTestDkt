package com.donglan.dao.impl;

import com.donglan.dao.UserDao;
import com.donglan.pojo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/*
* 使用DBUtils来执行sql语句
* */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public User findById(Integer id) throws SQLException {
        String sql = "select *from user where id = ?";
        return queryRunner.query(sql,new BeanHandler<>(User.class),id);
    }

    public void addUser(User user) throws SQLException {
        String sql = "insert into user values(null,?,?,?)";
        queryRunner.update(sql,user.getUsername(),user.getPassword(),user.getNickname());
    }

    public void deleteUserById(Integer id) throws SQLException {
        String sql = "delete from user where id = ?";
        queryRunner.update(sql,id);
    }

    public void updateUser(User user) throws SQLException {
        String sql = "update user set username=?,password=?,nickname=? where id=?";
        queryRunner.update(sql,user.getUsername(),user.getPassword(),user.getNickname(),user.getId());
    }
}
