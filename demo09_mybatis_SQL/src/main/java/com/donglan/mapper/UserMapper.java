package com.donglan.mapper;

import com.donglan.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {


    /*
    * 根据地址address来查询用户数据，如果没有传入地址的话，就查询出来所有用户
    * */
    List<User> findUserListByAddress(@Param("address") String address);

    /*
    * 根据用户的性别和地址作为查询条件
    * */
    List<User> findUserListByAddressAndSex(User user);
    List<User> findUserListByAddressAndSex2(User user);
    List<User> findUserListByAddressAndSex3(User user);

    /*
    * 更新用户
    * */
    void updateUser(User user);

    /*
    * 通过id查找用户
    * */
    User findUserById(Integer id);

    /*
    * 批量删除，根据id的集合删除所有元素
    * */
    void deleteByIds(List<Integer> ids);
}
