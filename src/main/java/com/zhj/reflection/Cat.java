package com.zhj.reflection;

/**
 * @author zhj
 */
public class Cat {

    private String name = "大脸猫";

    public int age = 10;

    public Cat() {

    }

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHi() {
        System.out.println("Hi");
    }

}
