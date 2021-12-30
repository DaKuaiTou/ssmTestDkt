package com.donglan.controller;

import com.donglan.pojo.User;
import com.donglan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public List<User> findAll(){
        return userService.findAllUser();
    }

    public User findUserById(Integer id){
        return userService.findUserById(id);
    }

    public void deleteById(Integer id) {
        userService.deleteById(id);
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public void updateUser(User user) {
        userService.updateUser(user);
    }
}
