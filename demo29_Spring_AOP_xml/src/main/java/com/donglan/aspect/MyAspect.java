package com.donglan.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MyAspect {

    public void checkPermission(){
        System.out.println("进行权限校验");
    }

    public void printResult(String returnValue){
        // 获取的是被增强方法的返回值，一般返回String
        System.out.println("方法执行完毕，返回值是："+returnValue);
    }

    public void printException(Throwable errorMsg){
        // 将异常信息捕捉并且打印到控制台
        System.out.println("将获取到的异常信息打印出来");
        System.out.println(errorMsg.getMessage());
    }

    public void close(){
        System.out.println("执行资源回收的操作...");
    }

    public Object totalTime(ProceedingJoinPoint joinPoint){
        try {
            // 获取当前的实践
            long startTime = System.currentTimeMillis();
            // 执行切入点
            Object proceed = joinPoint.proceed();
            // 执行完毕之后的时间
            long endTime = System.currentTimeMillis();
            System.out.println("时间差为："+(endTime - startTime));
            return "环绕测试时间："+proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new RuntimeException(throwable.getMessage());
        }
    }

}
