package com.donglan.test;

import com.donglan.service.UserService;
import com.donglan.service.impl.UserServiceImpl;
import com.donglan.utils.BeanFactory;
import com.donglan.utils.BeanFactory2;
import com.donglan.utils.BeanFactory3;
import org.junit.Test;

public class FactoryTest {
    /*
    * 原始方式
    * */
    @Test
    public void test1(){
        // 1. 创建UserServiceImpl的对象
        UserServiceImpl userService = new UserServiceImpl();
        // 2. 调用addUser()方法
        userService.addUser();
    }

    /*
    * 接口方式
    * */
    @Test
    public void test2(){
        // 1. 声明一个接口对象，接受子类实例化对象
        UserService userService = new UserServiceImpl();
        userService.addUser();
    }

    /*
    * 工厂模式/反射方式
    * */
    @Test
    public void test3() throws Exception {
        // 1. 定义接口来接受反射的回来的对象
        UserService userService = (UserService) Class.forName("com.donglan.service.impl.UserServiceImpl").newInstance();
        // 2. 调用addUser()方法
        userService.addUser();
    }
    /*
    * 以上的代码中，属于字符串硬编码的方式，所以在实际开发中，我们几乎很少使用反射的方式去创建对象，基本上反射的相关代码都已经封装好了的
    * 所以，这个时候，我们就来封装一个类，在工具类中使用反射的方式来创建对象
    * */

    /*
    * 工厂模式降低耦合
    * */
    @Test
    public void test4(){
        /*
        * 异常分为编译异常和运行异常
        *   编译时异常：就是我们在写代码的过程中必须要处理的异常，
        *   运行时异常：编译的时候，我们写代码的时候不会出现报错异常提醒，而是在代码运行的时候出现的异常信息
        * */
        UserService userService = (UserService) BeanFactory.createBean("com.donglan.service.impl.UserServiceImpl");
        userService.addUser();
    }
    /*
    * test4的测试虽然进一步的优化了，但是依然存在字符串硬编码的问题存在
    * 虽然当我们的实现类删除的话，代码编译的时候不会报错，运行的时候肯定报错
    * 另外一点不好的地方，实现类删除了，那么在使用这个实现类的地方，我们还需要一点一点去找，也是比较麻烦的
    * */

    /*
    * 通过配置的方式完成的工厂模式创建对象
    * */
    @Test
    public void test5(){
        UserService userService = (UserService) BeanFactory2.createBean("userService");
        userService.addUser();

        UserService userService2 = (UserService) BeanFactory2.createBean("userService");
        userService2.addUser();

        System.out.println(userService == userService2);
    }
    /*
    * 以上代码的操作中，两个对象不是同一个，我们每次在获取对象的 时候，工厂都会重新创建新的对象给到我们
    * 我们需要进一步的优化，通过相同的id返回的对象应该时同一个【单例模式】
    *
    * 单例模式：饿汉式、懒汉式【都属于初始化的时候】
    * 优化的目的：加上容器式的单例模式
    *
    * */


    @Test
    public void test6(){
        UserService userService = (UserService) BeanFactory3.createBean("userService");
        userService.addUser();

        UserService userService2 = (UserService) BeanFactory3.createBean("userService");
        userService2.addUser();

        System.out.println(userService == userService2);
    }
    /*
    * 在程序初始化的时候，就解析bean.xml文件，将其全部存到容器Map中
    * 把bean标签的id作为map的key，bean标签的class属性进行反射创建对象之后作为map的value
    * 如果要使用对象，不需要在new了，而是从容器中直接获取即可。
    * */
}





