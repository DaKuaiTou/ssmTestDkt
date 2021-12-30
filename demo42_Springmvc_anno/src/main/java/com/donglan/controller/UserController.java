package com.donglan.controller;


import com.donglan.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.SessionScope;

import java.util.Date;


@Controller
@RequestMapping("/user")
@SessionAttributes(value = {"msg"})
public class UserController {

    @RequestMapping("/register")
    public String register(User user){
        System.out.println("注册的用户："+user);
        return "success";
    }

    @RequestMapping("/userJson")
    public String userJson(@RequestBody User user){
        // 目标：使用body参数来获取请求体中的内容，从请求体中获取参数，封装到User实体类对象中
        System.out.println("请求体的内容："+user);
        return "success";
    }

    /*
    * 请求检查一个订单，订单有订单id，订单对应的套餐id，再来一个结果id
    * 传统方式：http://127.0.0.1:8080/user?orderId=100100&mealId=111000&resultId=20211212
    * Rest：get请求方式   http://127.0.0.1:8080/user/100100/111000/20211212
    * */
    @RequestMapping(path = "/{orderId}/{mealId}/{resultId}",method = RequestMethod.GET)
    public String checkItem(@PathVariable("orderId")int orderId,@PathVariable("mealId")int mealId,@PathVariable("resultId")int resultId){
        // 目标：使用body参数来获取请求体中的内容，从请求体中获取参数，封装到User实体类对象中
        System.out.println("根据id进行检查：orderId:"+orderId+",mealId:"+mealId+",resultId:"+resultId);
        return "success";
    }

    @RequestMapping(path = "/{orderId}/{mealId}/{resultId}",method = RequestMethod.DELETE)
    public String deleteItem(@PathVariable("orderId")int orderId,@PathVariable("mealId")int mealId,@PathVariable("resultId")int resultId){
        // 目标：使用body参数来获取请求体中的内容，从请求体中获取参数，封装到User实体类对象中
        System.out.println("根据id进行删除：orderId:"+orderId+",mealId:"+mealId+",resultId:"+resultId);
        return "success";
    }

    // 获取请求头信息
    @RequestMapping("/getAccept")
    public String getAccept(@RequestHeader(value = "Accept") String accept){
        System.out.println("请求头accept的信息："+accept);
        return "success";
    }

    // 获取名字叫做 JSESSIONID的cookie值
    @RequestMapping("/getCookieValue")
    public String getCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println("获取的cookie的值为："+cookieValue);
        return "success";
    }

    // 更新用户
    @RequestMapping("/updateUser")
    public String updateUser(User user){
        System.out.println("更新的用户数据是："+user);
        return "success";
    }

    // 先控制器方法之前执行该方法
/*    @ModelAttribute
    public User getUserById(int id){
        System.out.println("根据id来查询用户信息："+id);
        User user = new User();
        user.setBirthday(new Date());
        return user;
    }*/

    // 让session域对象msg存入一个值
    @RequestMapping("/msg")
    public String msg(Model model){
        // model表示的数据模型，其实也就是往域对象中存放数据
        model.addAttribute("msg","我是域对象中msg的值");
        return "success";
    }


}














