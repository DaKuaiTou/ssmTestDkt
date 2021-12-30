package com.donglan.dao;

import com.donglan.pojo.User;

import java.sql.SQLException;

public interface UserDao {
    /*
    * 根据id查找用户
    * */
    User findById(Integer id) throws SQLException;
    /*
    * 添加用户
    * */
    void addUser(User user) throws SQLException;
    /*
    * 根据id删除用户
    * */
    void deleteUserById(Integer id) throws SQLException;
    /*
    * 更新用户
    * */
    void updateUser(User user) throws SQLException;
}
