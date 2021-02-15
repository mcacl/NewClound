package com.example.consumer.ctrl;

import com.example.consumer.server.impl.ImplLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;

/**
 * 创建时间:2020/10/4
 * 创建人:pmc
 * 描述:
 */
@RestController
@RequestMapping("/login")
public class CtrlLogincosm {
    @Autowired
    private ImplLogin implLogin;

    @RequestMapping("/in")
    public String in(@RequestParam String name, @RequestParam String psd) {
        return implLogin.loginin(name, psd);
    }

    @RequestMapping("/inrest")
    public String inrest(@RequestParam String name, @RequestParam String psd) {
        return implLogin.logininrest(name, psd);
    }
}
