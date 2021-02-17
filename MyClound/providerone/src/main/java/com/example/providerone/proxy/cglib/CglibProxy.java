package com.example.providerone.proxy.cglib;

import com.example.providerone.proxy.Log;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 创建时间:2021/2/17
 * 创建人:pmc
 * 描述:
 */
public class CglibProxy implements MethodInterceptor {
    private Log log;
    private Object target;

    public CglibProxy() {
    }

    public Object creatProxy(Log log, Object target) {
        this.log = log;
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());//设置父类为目标类
        enhancer.setCallback(this);
        return enhancer.create();//创建子类
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String mname = method.getName();
        if (mname.equals("save")) {
            log.info("cglib");
        }
        return method.invoke(this.target, objects);
    }
}
