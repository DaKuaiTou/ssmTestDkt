package com.donglan.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibTest {

    public static void main(String[] args) {

        // 创建目标对象
        Target target = new Target();
        // 创建增强器
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(Target.class);
        // 设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("方法执行前的业务操作");
                Object invoke = method.invoke(target, objects);
                System.out.println("方法执行后的业务操作");
                return invoke;
            }
        });


        // 调用代理对象进行测试
        // 创建代理对象
        Target proxy = (Target) enhancer.create();
        proxy.method();
    }

}
