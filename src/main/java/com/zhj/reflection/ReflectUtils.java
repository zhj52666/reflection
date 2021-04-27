package com.zhj.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zhj
 */
public class ReflectUtils {

    public static void main(String[] args) throws ClassNotFoundException {
        api_g01();
    }

    public static void api_g01() throws ClassNotFoundException {
        Class personCls = Class.forName("com.zhj.reflection.Person");
        System.out.println(personCls.getName());
        System.out.println(personCls.getSimpleName());
        System.out.println(personCls.getPackage());
        System.out.println("所有接口信息:");
        for (Class anInterface : personCls.getInterfaces()) {
            System.out.println(anInterface);
        }
        System.out.println("本类与父类的public属性：");
        for (Field field : personCls.getFields()) {
            System.out.println(field);
        }
        System.out.println("本类所有的属性：");
        for (Field declaredField : personCls.getDeclaredFields()) {
            System.out.println(declaredField);
        }
        System.out.println("本类与父类的public方法：");
        for (Method method : personCls.getMethods()) {
            System.out.println(method);
        }
        System.out.println("本类的所有方法：");
        for (Method declaredMethod : personCls.getDeclaredMethods()) {
            System.out.println(declaredMethod);
        }
        System.out.println("本类的public构造器：");
        for (Constructor constructor : personCls.getConstructors()) {
            System.out.println(constructor);
        }
        System.out.println("本类所有的构造器：");
        for (Constructor declaredConstructor : personCls.getDeclaredConstructors()) {
            System.out.println(declaredConstructor);
        }
        System.out.println("本类与父类的public注解：");
        for (Annotation annotation : personCls.getAnnotations()) {
            System.out.println(annotation);
        }
        System.out.println("本类所有的注解：");
        for (Annotation declaredAnnotation : personCls.getDeclaredAnnotations()) {
            System.out.println(declaredAnnotation);
        }
    }

    public static void api_g02() throws ClassNotFoundException {
        Class personCls = Class.forName("com.zhj.reflection.Person");
        System.out.println("本类所有的属性：");
        for (Field declaredField : personCls.getDeclaredFields()) {
            System.out.println(declaredField);
            System.out.println("属性修饰符:" + declaredField.getModifiers());
            System.out.println("属性类型：" + declaredField.getType());
            System.out.println("属性注解：");
            for (Annotation annotation : declaredField.getAnnotations()) {
                System.out.println(annotation);
            }
        }
    }

}

interface IA {

}
interface IB {

}

class Biology {
    public String height;

    public void m() {

    }

    Biology() {

    }

    public Biology(String height) {

    }
}

@Deprecated
class Person extends Biology implements IA,IB {

    @Deprecated
    public String name = "大强";
    protected int age = 11;
    String job = "程序员";
    private double sal;

    // 方法m1
    public void m1() {

    }
    // 方法m2
    protected void m2() {

    }
    // 方法m3
    void m3() {

    }
    // 方法m4
    private void m4() {

    }

    Person() {

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                '}';
    }
}
