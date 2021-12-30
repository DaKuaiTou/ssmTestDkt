package com.donglan.controller;

import com.donglan.pojo.Result;
import com.donglan.pojo.User;
import com.donglan.service.UserService;
import org.apache.ibatis.executor.ReuseExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody// 该注解放在类上表示所有的controller方法返回的都是json格式
@RequestMapping("/user")// 表示一级目录的url
public class UserController {

    @Autowired
    private UserService userService;

    /*
    * 查询所有用户的controller
    *
    * 为了保险起见，我们最好加一个try...catch，查询失败的话可以向前端返回失败信息
    * */
    @RequestMapping("/findAll")
    public Result findAll(){
        try {
            List<User> userList = userService.findAll();
            Result result = new Result(true,userList,"查询成功");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            Result result = new Result(false,null,"查询失败");
            return result;
        }
    }

    /*
    * 根据id删除用户
    *
    * 使用的是restful风格的url，所以这里直接传入一个id即可
    * */
    @RequestMapping("/{id}")
    public Result deleteById(@PathVariable("id") int id){
        try {
            userService.deleteById(id);
            Result result = new Result(true,null,"删除用户信息成功");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            Result result = new Result(false,null,"删除用户信息失败");
            return result;
        }
    }

    /*
    * 添加用户
    *
    * 前端异步请求发送用户信息的json请求体
    * */
    @RequestMapping("/addUser")
    public Result addUser(@RequestBody User user){
        try {
            userService.addUser(user);
            Result result = new Result(true,null,"保存用户信息成功");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            Result result = new Result(false,null,"保存用户信息失败");
            return result;
        }
    }
}
