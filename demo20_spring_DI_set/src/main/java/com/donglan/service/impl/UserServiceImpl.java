package com.donglan.service.impl;

import com.donglan.pojo.User;
import com.donglan.dao.UserDao;
import com.donglan.service.UserService;

import java.util.*;


public class UserServiceImpl implements UserService {


    private UserDao userDao;
    private String username;
    private Integer age;
    private List<String> list;
    private List<User> userList;
    private Map<String,User> userMap;
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void findUser() {
        System.out.println("UserServiceImpl findUser method running");
        System.out.println(username+"，"+age);
        System.out.println(list);
        System.out.println(userList);
        Set<String> keys = userMap.keySet();
        Iterator<String> iterator = keys.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key+":"+userMap.get(key));
        }
        System.out.println(properties);
        userDao.findUser();
    }
}
