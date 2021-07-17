package com.example.providerone.test;

/**
 * 创建时间:2021/3/17
 * 创建人:pmc
 * 描述:
 */
public class TClassChild extends TClass {
    public TClassChild(String name, Integer age) {
        super(name, age);
    }

    public TClassChild(String name, int age) {
        super(name, age);
    }

    @Override
    public String info() {
        String res = "TClassChild.info()";
        System.out.println(res);
        return res;
    }

    public void stanfun() {
        String res = "TClassChild.stanfun()";
        System.out.println(res);
    }
}
