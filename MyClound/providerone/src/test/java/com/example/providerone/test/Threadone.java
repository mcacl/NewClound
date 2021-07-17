package com.example.providerone.test;

import java.util.concurrent.Callable;

/**
 * 创建时间:2021/3/18
 * 创建人:pmc
 * 描述:
 */
public class Threadone implements Callable<String> {
    private int _num;

    public Threadone(int num) {
        this._num = num;
    }

    @Override
    public String call() throws Exception {
        String res = "线程" + this._num + "启动";
        return res;
    }
}
