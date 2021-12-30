package com.donglan.mapper;

import com.donglan.pojo.User;

import java.util.List;

public interface UserMapper {

    /*
    * 查询所有用户数据
    * */
    List<User> findAllUsers();

    /*
    * 新增用户
    * */
    void addUser(User user);

    /*
     * 根据用户id查询用户 #{}
     * */
    User findUserById(Integer id);

    /*
     * 根据用户id查询用户 ${}
     * */
    User findUserByUsername(String username);

    /*
    * 根据用户对象，更新用户数据
    * */
    void updateUser(User user);

    /*
    * 根据用户id，删除用户
    * */
    void deleteUser(Integer id);

    /*
    * 模糊查询方式一
    * */
    List<User> searchUserByUsername1(String username);

    /*
     * 模糊查询方式二
     * */
    List<User> searchUserByUsername2(String username);

    /*
     * 模糊查询方式三
     * */
    List<User> searchUserByUsername3(String username);
}
