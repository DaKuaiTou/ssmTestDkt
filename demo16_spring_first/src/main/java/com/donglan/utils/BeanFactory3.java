package com.donglan.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 容器式单例
*   也就是说，我将对象的创建放在了容器中，然后每当有需要该对象的地方直接通过该容器来获取即可。
*
*   这样做的好处，就是每次获取的对象都是从容器中获取的，保证都是同一个对象
*   因为一开始我就创建好了对象，且放在了容器中，你需要我就给你
*
*
* 这个时候map变成了管理单例对象的容器
* */
public class BeanFactory3 {

    // 这是我们的容器，方便将调用者的id获取到之后拿到对应的class
    private static Map<String,Object> map = new HashMap<String, Object>();

    /*
     * 将配置文件读取的代码写到静态代码块中
     * 静态代码块只会在类加载的时候执行一次
     * 解析bean.xml，根据id获取的要创建对象的全限定名，放到map中
     * */
    static {
        // DOM4J解析bean.xml文件
        SAXReader saxReader = new SAXReader();
        // 加载xml文件
        InputStream inputStream = BeanFactory3.class.getClassLoader().getResourceAsStream("bean.xml");
        // 解析
        try {
            Document document = saxReader.read(inputStream);
            // 获取bean.xml中的所有bean标签
            List<Element> list=document.getRootElement().elements();

            for (Element element : list) {
                /*
                * 在这里，我们直接将解析到的class全限定名，直接将其反射创建成对象，然后在放到map的id对应的value中
                * */
                map.put(element.attributeValue("id"),Class.forName(element.attributeValue("class")).newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    * 根据bean标签的id值哦来获取标签的class的属性值，然后在使用反射
    * */
    public static Object createBean(String id){

        try {
            // 从map中根据id获取对象
           return map.get(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

    }

}













