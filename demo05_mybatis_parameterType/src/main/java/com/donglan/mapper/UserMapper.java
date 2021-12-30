package com.donglan.mapper;

import com.donglan.pojo.QueryUser;
import com.donglan.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    /*
    * 更新用户
    * */
    void updateUserByMap(Map umap);

    /*
    * 传递多个参数，通过用户的名字和地址查找用户
    *   第一种方式：索引的方式
    * */
    User searchuserByUsernameAndAddress1(String username,String address);

    /*
     * 传递多个参数，通过用户的名字和地址查找用户
     *   第二种方式：索引的方式
     * */
    User searchuserByUsernameAndAddress2(@Param("username") String username, @Param("address") String address);

    /*
    * 传递pojo包装类类型
    * */
    List<User> searchByCondition(QueryUser queryUser);

}
