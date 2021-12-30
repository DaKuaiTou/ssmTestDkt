package com.donglan.mapper;

import com.donglan.pojo.Role;

public interface RoleMapper {

    /*
    * 根据角色的id来查找角色信息，并且连接用户表查询该角色该角色所属的用户信息
    * */
    Role findRoleUserListByRid(Integer rid);
}
