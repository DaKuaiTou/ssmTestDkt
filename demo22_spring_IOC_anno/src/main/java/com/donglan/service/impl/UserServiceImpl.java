package com.donglan.service.impl;

import com.donglan.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
 * <bean id=userServiceImpl class="com.donglan.service.impl.UserServiceImpl">
* */
@Scope("prototype")
@Component
public class UserServiceImpl implements UserService {
    public void addUser() {

    }


}
