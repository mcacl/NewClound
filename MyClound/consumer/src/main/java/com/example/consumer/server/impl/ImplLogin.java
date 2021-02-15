package com.example.consumer.server.impl;

import com.example.consumer.feignclients.ILogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建时间:2020/10/4
 * 创建人:pmc
 * 描述:
 */
@Service
public class ImplLogin {
    @Autowired
    private ILogin iLogin;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用feign 方式
     *
     * @param name
     * @param psd
     * @return
     */
    public String loginin(String name, String psd) {
        String res = iLogin.in(name, psd);
        System.out.println("调用提供者feign 返回值:" + res);
        return res;
    }

    public String logininrest(String name, String psd) {
        Object res = restTemplate.getForObject("http://providerone/login/in?name=" + name + "&psd=" + psd, String.class);
        System.out.println("restemplate+ribbon:" + res.toString());
        return res.toString();
    }
}
