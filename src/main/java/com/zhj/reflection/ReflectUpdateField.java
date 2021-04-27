package com.zhj.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author zhj
 */
public class ReflectUpdateField {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class personCls = Class.forName("com.zhj.reflection.Person");
        Object o = personCls.newInstance();
        System.out.println(o);
        System.out.println("本类所有的属性：");
        for (Field declaredField : personCls.getDeclaredFields()) {
            System.out.println(declaredField);
            System.out.println("属性修饰符:" + declaredField.getModifiers());
            System.out.println("属性类型：" + declaredField.getType());
            System.out.println("属性注解：");
            for (Annotation annotation : declaredField.getAnnotations()) {
                System.out.println(annotation);
            }
            System.out.println("----------------------------------------");
        }
        Field name = personCls.getField("name");
        name.set(o,"zhj");
        Field sal = personCls.getDeclaredField("sal");
        // sal.set(o,3000); 非法
        sal.setAccessible(true);
        sal.set(o,3000);
        System.out.println("update obj:" + o);

        System.out.println("git by zhj");
    }

}
