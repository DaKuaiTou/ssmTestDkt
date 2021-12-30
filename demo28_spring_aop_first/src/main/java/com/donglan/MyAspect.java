package com.donglan;

public class MyAspect {

    //增强方法：方法之前执行，【前置增强】
    public void beforeMethod(){
        System.out.println("前置通知方法执行...");
    }


}
