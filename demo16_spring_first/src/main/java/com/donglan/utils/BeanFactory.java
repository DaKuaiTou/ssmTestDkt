package com.donglan.utils;

public class BeanFactory {
    /*
    * 根据类的全限定名，来创建对象
    * */
    public static Object createBean(String className) {
        try {
            // 因为forName和newInstance都有异常
            // 所以我们尽量在这里就将一场给消化掉，不要让调用者在编译的时候出现异常，
            return Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            // 不需要调用者在写代码的过程中出现编译异常，我们在工具类中进行处理
            // 但是也需要调用者获取异常的信息
            throw new RuntimeException(e.getMessage());
        }
    }

}
