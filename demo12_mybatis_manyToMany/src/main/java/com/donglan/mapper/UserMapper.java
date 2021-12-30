package com.donglan.mapper;

import com.donglan.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /*
    * 根据用户的id查找用户的信息，并且连接角色表获得该用户在角色表中的角色信息
    * */
    User findUserRoleListByUid(Integer uid);
}
