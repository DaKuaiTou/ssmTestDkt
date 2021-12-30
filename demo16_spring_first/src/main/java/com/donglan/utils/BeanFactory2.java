package com.donglan.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory2 {

    // 这是我们的容器，方便将调用者的id获取到之后拿到对应的class
    private static Map<String,String> map = new HashMap<String, String>();

    /*
     * 将配置文件读取的代码写到静态代码块中
     * 静态代码块只会在类加载的时候执行一次
     * 解析bean.xml，根据id获取的要创建对象的全限定名，放到map中
     * */
    static {
        // DOM4J解析bean.xml文件
        SAXReader saxReader = new SAXReader();
        // 加载xml文件
        InputStream inputStream = BeanFactory2.class.getClassLoader().getResourceAsStream("bean.xml");
        // 解析
        try {
            Document document = saxReader.read(inputStream);
            // 获取bean.xml中的所有bean标签
            List<Element> list=document.getRootElement().elements();

            for (Element element : list) {

                String id=element.attributeValue("id");
                String clazz=element.attributeValue("class");
                map.put(id,clazz);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /*
    * 根据bean标签的id值哦来获取标签的class的属性值，然后在使用反射
    * */
    public static Object createBean(String id){

        try {
            // 从map中根据id获取class的值
            String className = map.get(id);
            if (className != null && className != ""){
                //  就可以使用反射来创建对象
                return Class.forName(className).newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

}













