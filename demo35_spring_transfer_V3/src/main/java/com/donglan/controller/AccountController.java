package com.donglan.controller;

import com.donglan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    /*
    * 转账方法
    * */
    public void transfer(String fromName,String toName,Double Money){
        accountService.transfer(fromName, toName, Money);
    }

}
