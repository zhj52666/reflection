package com.zhj.classload_;

/**
 * @author zhj
 */
public class ClassLoad {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        /**
         * 1.加载B类，并生成B的class
         * 2.连接 num = 0
         * 3.初始化
         * 自动收集所有静态变量的赋值动作和静态代码块的语句
         * clinit() {
         *   System.out.println("static code");
         *   // num = 300; 合并num = 300无效
         *   num = 100;
         * }
         *
         * 保证内存只有一个类对象
         * synchronized (getClassLoadingLock(name)) {
         *          // First, check if the class has already been loaded
         *  }
         */
        // new B();
        // B.class.newInstance();
        // 使用B的属性也会加载B.class
        System.out.println(B.num);
    }
}

class A {
    // 属性-成员变量-字段
    // 1. n1 是实例属性，不是静态变量，因此在准备阶段，是不会分配内存
    // 2. n2 是静态变量，因此在准备阶段，会分配内存 n2 默认初始化0 ，而不是20
    // 3. n3 是常量，它和静态变量不一样，因为一旦赋值就不变 n3=30
    public int n1 = 10;
    public static int n2 = 20;
    public static final int n3 = 30;
}

class B {
    static {
        System.out.println("static code");
        num = 300;
    }
    static int num = 100;

    public B() {
        System.out.println(num);
        System.out.println("B的构造");
    }
}