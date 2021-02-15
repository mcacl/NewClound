package com.example.providerone.ctrl;

import com.example.providerone.ctrl.iface.ILogin;
import com.example.providerone.entity.User;
import com.example.providerone.server.ServLogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.util.List;

/**
 * 创建时间:2020/10/3
 * 创建人:pmc
 * 描述:
 */
@RequestMapping("login")
@RestController
public class CtrlLogin implements ILogin<User> {
    @Autowired
    private ServLogin servLogin;

    @Override
    public String in(@ApiParam("用户名") @RequestParam String name, @ApiParam("密码") @RequestParam String psd) {
        return name + psd;
    }

    @Override
    public List<User> list() {
        return servLogin.list();
    }

    @Override
    public void add(User user) {
        servLogin.add(user);
    }

    @Override
    public void delete(User user) {
        servLogin.delete(user);
    }

    @Override
    public void update(User user) {
        servLogin.update(user);
    }

    @Override
    public void addCache(User user) {
        servLogin.addCache(user);
    }

}