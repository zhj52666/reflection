package com.zhj.class_;

import com.zhj.reflection.Cat;

import java.lang.reflect.Constructor;

/**
 * @author zhj
 */
public class GetClass {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        // 1.编译阶段  配置文件
        Class<?> class1 = Class.forName("com.zhj.reflection.Cat");
        System.out.println(class1);
        // 2.类加载阶段  参数传递
        Class class2 = Cat.class;
        Constructor constructorHasName = class1.getConstructor(String.class);
        System.out.println(class2);
        // 3.已经知道对象了
        Cat cat = new Cat();
        Class class3 = cat.getClass();
        System.out.println(class3);
        // 4.通过类加载器来获取
        ClassLoader classLoader = cat.getClass().getClassLoader();
        Class<?> class4 = classLoader.loadClass(class1.getName());
        System.out.println(class4);
        // 5.基本数据类型
        Class intCls1 = int.class;
        System.out.println(intCls1);
        // 6. 基本数据类型对应包装类
        Class intCls2 = Integer.TYPE;
        System.out.println(intCls2);
        Class integerCls = Integer.class;
        System.out.println(integerCls);
    }
}
