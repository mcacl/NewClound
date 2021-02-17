package com.example.providerone.proxy;

import com.example.providerone.proxy.Iface;

/**
 * 创建时间:2021/2/17
 * 创建人:pmc
 * 描述:
 */
public class ImplIface implements Iface {
    @Override
    public String save() {
        System.out.println("JDK保存成功");
        return "JDK保存成功!";
    }
}
