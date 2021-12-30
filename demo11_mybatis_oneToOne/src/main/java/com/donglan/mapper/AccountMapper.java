package com.donglan.mapper;

import com.donglan.pojo.Account;

public interface AccountMapper {

    /*
    * 根据aid查询账户信息，并且连接上t_user用户表查询该账户所属的用户信息
    * */
    Account findAccountUserByAid(Integer aid);
}
