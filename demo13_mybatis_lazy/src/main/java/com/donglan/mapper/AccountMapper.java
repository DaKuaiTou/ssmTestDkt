package com.donglan.mapper;

import com.donglan.pojo.Account;

public interface AccountMapper {

    /*
    * 根据账户id查询账户信息
    * */
    Account findAccountByAid(Integer aid);

    /*
    * 根据uid查询账户信息
    * */
    Account findAccountByuid(Integer uid);

}
