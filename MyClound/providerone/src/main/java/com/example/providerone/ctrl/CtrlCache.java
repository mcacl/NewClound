package com.example.providerone.ctrl;

import com.example.providerone.entity.User;
import com.example.providerone.server.ServCache;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding.Use;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 创建时间:2021/2/15
 * 创建人:pmc
 * 描述:
 */
@Api("缓存测试服务")
@RestController
@RequestMapping(value = "cache")
public class CtrlCache {

    @Autowired
    private ServCache servCache;

    @ApiOperation(value = "id缓存查询", httpMethod = "POST")
    @RequestMapping("queryid")
    public User queryid(@RequestParam @ApiParam("id") Long id) {
        return servCache.queryid(id);
    }

    @ApiOperation(value = "list缓存查询", httpMethod = "POST")
    @RequestMapping("list")
    public List<User> list() {
        return servCache.list();
    }

    @ApiOperation(value = "指定id范围缓存查询", httpMethod = "POST")
    @RequestMapping("querylist")
    public List<User> querylist(@RequestParam @ApiParam("id") Long id) {
        return servCache.querylist(id);
    }

    @ApiOperation(value = "增加并加缓存", httpMethod = "POST")
    @RequestMapping("add")
    public User add(@ApiParam("用户") User user) {
        return servCache.add(user);
    }

    @ApiOperation(value = "删除且删除缓存", httpMethod = "POST")
    @RequestMapping("del")
    public void del(@RequestParam @ApiParam("id") Long id) {
        servCache.del(id);
    }

    @ApiOperation(value = "删除且清空缓存", httpMethod = "POST")
    @RequestMapping("delcache")
    public void delcache(@RequestParam @ApiParam("id") Long id) {
        servCache.delcache(id);
    }
}
