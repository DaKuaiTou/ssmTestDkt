package com.donglan.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TargetTest {
    public static void main(String[] args) {
        // 创建目标对象
        Target target = new Target();

        // 创建代理对象
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("方法执行前的业务操作");
                Object invoke = method.invoke(target, args);
                System.out.println("方法执行后的业务操作");
                return invoke;
            }
        });

        // 调用代理对象的方法进行测试
        // 当调用接口的任何方法的时候，代理对象的代码都无需修改
        proxy.method();
    }
}
