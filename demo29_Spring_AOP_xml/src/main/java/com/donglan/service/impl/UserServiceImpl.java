package com.donglan.service.impl;

import com.donglan.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public void add() {
        System.out.println("执行添加...");
        int number = 1/0;
    }

    public void deleteById(Integer id) {
        System.out.println("执行删除...");
    }

    public void update() {
        System.out.println("执行更新");
    }

    public String query() {

        try {
            Thread.sleep(3000);
            System.out.println("执行查询");
            return "冬澜有雪";
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
