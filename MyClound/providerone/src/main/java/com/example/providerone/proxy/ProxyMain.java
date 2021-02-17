package com.example.providerone.proxy;

import com.example.providerone.proxy.cglib.CglibProxy;
import com.example.providerone.proxy.jdkproxy.ImplIfaceProxy;

import java.lang.reflect.Proxy;

/**
 * 创建时间:2021/2/17
 * 创建人:pmc
 * 描述:
 */
public class ProxyMain {
    public static void main(String[] args) {
        Log log = new Log();
        //jdk代理 必须有接口
        Iface jdk = new ImplIface();
        ImplIfaceProxy jdkproxy = new ImplIfaceProxy(log, jdk);
        Iface jdkiface = (Iface) Proxy.newProxyInstance(jdk.getClass().getClassLoader(), jdk.getClass().getInterfaces(), jdkproxy);
        jdkiface.save();

        //cglib
        Iface cglib = new ImplIface();
        CglibProxy cglibProxy = new CglibProxy();
        Iface cglibface = (Iface) cglibProxy.creatProxy(log, cglib);
        cglibface.save();

    }
}
