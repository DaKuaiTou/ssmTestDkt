package com.donglan.dao.impl;

import com.donglan.dao.UserDao;
import com.donglan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findUserById(Integer id) {
        List<User> list = jdbcTemplate.query("select *from user where id = ?", new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setNickname(resultSet.getString("nickname"));
                user.setId(resultSet.getInt("id"));
                return user;
            }
        }, id);

        return list.isEmpty() ? null:list.get(0);
    }

    public User findUserByUsername(String username) {

        List<User> list = jdbcTemplate.query("select *from user where username = ?", new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setNickname(resultSet.getString("nickname"));
                user.setId(resultSet.getInt("id"));
                return user;
            }
        }, username);

        if (list.size() > 1){
            System.out.println("查询出来的结果有很多，");
        }

        return list.get(0);
    }

    public void updateUser(User user) {
        jdbcTemplate.update("update user set username=?,password=?,nickname=? where id=?",
                user.getUsername(),user.getPassword(),user.getNickname(),user.getId());

    }
}
