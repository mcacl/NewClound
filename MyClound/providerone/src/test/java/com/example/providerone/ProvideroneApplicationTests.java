package com.example.providerone;

import com.example.providerone.test.TClass;
import com.example.providerone.test.TClassChild;
import com.example.providerone.test.Threadone;
import org.apache.catalina.util.Extension;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

@SpringBootConfiguration
@SpringBootTest
class ProvideroneApplicationTests {
    private String msg = "0.0";

    @Test
    void contextLoads() {
        int b = 128;
        Integer a = 128;
        Integer c = 128;
        Assert.isTrue(a.equals(b), "a.equals(b)错误");
        Assert.isTrue(a == b, "a==b错误");
        A a1 = new A();
        a1.afun();
        Field[] field = TClass.class.getFields();
        for (Field field1 : field) {
            System.out.println("field:" + field1.getName());
        }
        Field[] fieldd = TClass.class.getDeclaredFields();
        for (Field field1 : fieldd) {
            System.out.println("dfield:" + field1.getName());
        }
        Constructor<?>[] constructors = TClass.class.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        try {
            Constructor constructor = TClass.class.getConstructor(String.class, int.class);
            TClass tClass = (TClass) constructor.newInstance("小明1", 20);
            tClass.info();
            TClass t2 = new TClass("小红", 20);
            t2.info();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        List<String> list = new ArrayList<>();
        list.add("123");
        changeList(list);
        list.forEach(it -> {
            System.out.println("原List:" + it);
        });
        String s1 = new String("s1");
        String s2 = "s1";
        System.out.println(s2 == "s1");

        List<Future<String>> future = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i <= 3; i++) {
            future.add(executorService.submit(new Threadone(i)));
        }
        future.forEach(it -> {
            try {
                System.out.println(it.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    public void changeList(List<String> list) {
        list.add("list被方法改变了");
        list.forEach(it -> {
            System.out.println("changeList:" + it);
        });
        list = null;
    }

    private class A {
        public void afun() {
            System.out.println(msg);
        }
    }
}

class Person {
    public static void say() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Person.say();
        Person man = new Person();
        man.say();
        Person woman = new Person();
        woman.say();
    }
}
