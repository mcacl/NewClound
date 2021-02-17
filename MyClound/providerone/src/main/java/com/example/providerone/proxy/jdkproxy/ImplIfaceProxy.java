package com.example.providerone.proxy.jdkproxy;

import com.example.providerone.proxy.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 创建时间:2021/2/17
 * 创建人:pmc
 * 描述:代理类
 */
public class ImplIfaceProxy implements InvocationHandler {
    private Log log;//拥有增强方法的类
    private Object target;//要增强的对象

    public ImplIfaceProxy(Log log, Object target) {
        this.log = log;
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj;//目标类返回值
        String mname = method.getName();
        if (mname.equals("save")) {
            log.info("JDKproxy");//当方法是info时增强
        }
        obj = method.invoke(this.target, args);
        return obj;
    }
}
