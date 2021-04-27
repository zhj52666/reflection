package com.zhj.class_;

import com.zhj.reflection.Cat;

/**
 * @author zhj
 */
public class Class01 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 1. Class类也是类，继承Object
        // 2. Class类对象不是new 出来的，而是系统创建的
        // (1) new 对象
        /**
         *    public Class<?> loadClass(String name) throws ClassNotFoundException {
         *         return loadClass(name, false);
         *    }
         *
         *    protected Class<?> loadClass(String name, boolean resolve)
         *         throws ClassNotFoundException
         *     {
         *         synchronized (getClassLoadingLock(name)) {
         *             // First, check if the class has already been loaded
         *             Class<?> c = findLoadedClass(name);
         *             if (c == null) {
         *                 long t0 = System.nanoTime();
         *                 try {
         *                     if (parent != null) {
         *                         c = parent.loadClass(name, false);
         *                     } else {
         *                         c = findBootstrapClassOrNull(name);
         *                     }
         *                 } catch (ClassNotFoundException e) {
         *                     // ClassNotFoundException thrown if class not found
         *                     // from the non-null parent class loader
         *                 }
         *
         *                 if (c == null) {
         *                     // If still not found, then invoke findClass in order
         *                     // to find the class.
         *                     long t1 = System.nanoTime();
         *                     c = findClass(name);
         *
         *                     // this is the defining class loader; record the stats
         *                     sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
         *                     sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
         *                     sun.misc.PerfCounter.getFindClasses().increment();
         *                 }
         *             }
         *             if (resolve) {
         *                 resolveClass(c);
         *             }
         *             return c;
         *         }
         *     }
         *
         *     protected Object getClassLoadingLock(String className) {
         *         Object lock = this;
         *         if (parallelLockMap != null) {
         *             Object newLock = new Object();
         *             lock = parallelLockMap.putIfAbsent(className, newLock);
         *             if (lock == null) {
         *                 lock = newLock;
         *             }
         *         }
         *         return lock;
         *     }
         */
        Cat cat = new Cat();

        // 反射方式 也会进入loadClass 类的加载只能有一次  先获取classLoader加载器
        Class cls = Class.forName("com.zhj.reflection.Cat");
        System.out.println(cls);
        System.out.println(cls.getClass());
        System.out.println(cat.getClass());
        System.out.println(cls.getPackage().getName());
        System.out.println(cls.getName());
        Object o = cls.newInstance();
    }
}
