package com.donglan.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    /*
    * 定义两个切点
    * */

    @Pointcut("execution(* com.donglan.service.impl.UserServiceImpl.*(..))")
    public void pointcut1(){}
    @Pointcut("execution(public String com.donglan.service.impl.UserServiceImpl.query())")
    public void pointcut2(){}



    @Before("pointcut1()")
    public void checkPermission(){
        System.out.println("进行权限校验");
    }

    @AfterReturning("pointcut1()")
    public void printLog(){
        // 获取的是被增强方法的返回值，一般返回String
        System.out.println("方法执行完毕，返回值是："+"returnValue");
    }

    @AfterThrowing(pointcut = "pointcut1()",throwing = "errorMsg")
    public void printException(Throwable errorMsg){
        // 将异常信息捕捉并且打印到控制台
        System.out.println("将获取到的异常信息打印出来");
        System.out.println(errorMsg.getMessage());
    }

    @After("pointcut1()")
    public void close(){
        System.out.println("执行资源回收的操作...");
    }

    @Around("pointcut2()")
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
