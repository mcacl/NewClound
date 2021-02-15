package com.example.providerone.ctrl.iface;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 创建时间:2021/2/11
 * 创建人:pmc
 * 描述:
 */
@Api("提供用户登录相关服务")
public interface ILogin<T> {
    @ApiOperation(value = "用户登录处理", httpMethod = "POST")
    @RequestMapping(value = "in", method = {RequestMethod.POST})
    String in(@ApiParam("用户名") @RequestParam String name, @ApiParam("密码") @RequestParam String psd);

    @ApiOperation(value = "用户列表", httpMethod = "POST")
    @RequestMapping("list")
    List<T> list();

    @ApiOperation(value = "添加用户", httpMethod = "POST")
    @RequestMapping("add")
    void add(@RequestBody @ApiParam("user") T t);

    @ApiOperation(value = "删除用户", httpMethod = "POST")
    @RequestMapping("del")
    void delete(@RequestBody @ApiParam("user") T t);

    @ApiOperation(value = "修改用户", httpMethod = "POST")
    @RequestMapping("upd")
    void update(@RequestBody @ApiParam("user") T t);

    @ApiOperation(value = "增加缓存用户", httpMethod = "POST")
    @RequestMapping("adc")
    void addCache(@RequestBody @ApiParam("user") T t);

}
