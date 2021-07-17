package com.example.providerone.test;

/**
 * 创建时间:2021/3/15
 * 创建人:pmc
 * 描述:
 */
public class TClass {
    private String name;
    private int age;

    private TClass() {}

    public TClass(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    public TClass(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public Object info() {
        String info = "{name:" + this.name + ",age:" + this.age + "}";
        System.out.println(info);
        return info;
    }

    public static void stafun(String type) {
        System.out.println("TClass静态方法 >>" + type);
        System.out.println(TClass.class.getCanonicalName());
    }

    public void stanfun() {
        System.out.println("TClass非静态方法");
        info();
    }
}
