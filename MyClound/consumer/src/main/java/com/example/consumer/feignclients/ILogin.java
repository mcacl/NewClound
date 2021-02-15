package com.example.consumer.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 创建时间:2020/10/4
 * 创建人:pmc
 * 描述:
 */
@FeignClient(name = "providerone")
public interface ILogin {
    @RequestMapping("/login/in")
    public String in(@RequestParam("name") String name, @RequestParam("psd") String psd);
}
