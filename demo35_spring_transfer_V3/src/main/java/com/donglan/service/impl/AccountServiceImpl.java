package com.donglan.service.impl;

import com.donglan.dao.AccountDao;
import com.donglan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountDao accountDao;



    @Transactional
    public void transfer(String formName, String toName, Double money) {


    // 进行转账操作的相关业务
    // 调用dao层对象进行转出转入账户的操作
    accountDao.updateAccount(formName,-money);
    // 异常
    //int num = 1/0;
    accountDao.updateAccount(toName,+money);


    }
}
