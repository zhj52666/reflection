package com.zhj.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhj
 */
public class ReflectCreateObj {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 1.获取到user类的Class对象
        Class<?> cls = Class.forName("com.zhj.reflection.User");
        // 2.通过public的无参构造器创建实例
        Object obj1 = cls.newInstance();
        System.out.println(obj1);
        // 3.通过public的有参构造器创建实例
        Constructor<?> constructor = cls.getConstructor(String.class);
        Object zhj = constructor.newInstance("zhj");
        System.out.println(zhj);
        // 4.通过非public的有参构造器创建实例
        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(int.class, String.class);
        // Object xm = declaredConstructor.newInstance(21, "xm"); 非法的访问异常
        // 使用反射可以访问私有的，暴力破解
        declaredConstructor.setAccessible(true);
        Object xm = declaredConstructor.newInstance(21, "xm");
        System.out.println(xm);
    }

}

class User {
    private int age;
    private String name;

    public User() {

    }
    public User(String name) {
        this.name = name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
