package com.zhj.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author zhj
 */
public class ReflectionQuestion {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\main\\resources\\re.properties"));
        String classFullPath = properties.get("classFullPath").toString();
        String method = properties.get("method").toString();
        System.out.println("----------------");
        System.out.println("classfullpath = " + classFullPath + "  method = " + method);
        // 创建对象  不能使用new 的方式
        // new classfullpath()
        // 使用反射技术实现
        // 1.获得加载类
        Class cls = Class.forName(classFullPath);
        // 2.通过 class 可以获得一个加载的对象实例
        Object obj = cls.newInstance();
        System.out.println(obj.getClass());
        // 3.获得对象的方法
        Method objMethod = cls.getMethod(method);
        // 反射取消方法检查
        objMethod.setAccessible(true);
        // 4.对象执行方法
        objMethod.invoke(obj);

        // java.lang.reflect.Field 代表成员变量
        // 得到name字段
        // getField不能获得私有属性
        Field nameField = cls.getField("age");
        System.out.println(nameField.get(obj));
        // 获得构造器
        Constructor constructor = cls.getConstructor();
        System.out.println(constructor);
        // 获得有参构造器
        Constructor constructorHasName = cls.getConstructor(String.class);
        System.out.println(constructorHasName);
    }

}
