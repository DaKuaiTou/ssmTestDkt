package com.donglan.dao;

import org.apache.ibatis.annotations.Param;

public interface AccountDao {

    void updateAccount(@Param("name") String name, @Param("money") Double money);
}
