package com.example.providerone.server;

import com.example.providerone.dao.DaoUser;
import com.example.providerone.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 创建时间:2021/2/15
 * 创建人:pmc
 * 描述:
 */
//指定默认缓存区 缓存区：key的前缀，与指定的key构成redis的key，如 user::10001
@CacheConfig(cacheNames = "user")
@Service
public class ServCache {
    @Autowired
    private DaoUser daoUser;

    /**
     * @Cacheable 缓存有数据时，从缓存获取；没有数据时，执行方法，并将返回值保存到缓存中
     * 1) cacheNames 指定缓存区，没有配置使用@CacheConfig指定的缓存区
     * 2) key 指定缓存区的key
     * 3) 注解的值使用SpEL表达式
     * eq ==
     * lt <
     * le <=
     * gt >
     * ge >=
     */
    @Cacheable(key = "#id")
    public User queryid(Long id) {
        return daoUser.getOne(id);
    }

    @Cacheable(cacheNames = "list")
    public List<User> list() {
        return daoUser.findAll();
    }

    //condition 满足条件缓存数据 unless 满足条件时否决缓存数据
    @Cacheable(cacheNames = "list", condition = "#id le 2")
    public List<User> querylist(Long id) {
        Set<Long> Longs = new HashSet<>();
        if (id < 3) {
            Longs.add(1l);
            Longs.add(2l);
        } else {
            Longs.add(3l);
        }
        return daoUser.findAllById(Longs);
    }

    //@CachePut 一定会执行方法，并将返回值保存到缓存中
    @CachePut(key = "#user.id")
    public User add(User user) {
        daoUser.save(user);
        return user;
    }

    /**
     * 根据key删除缓存区中的数据
     */
    @CacheEvict(key = "#user.id")
    public void del(Long id) {
        daoUser.deleteById(id);
    }

    /**
     * allEntries = true ：删除整个缓存区的所有值
     * beforeInvocation = true ：默认false，表示调用方法之后删除缓存数据；true时，在调用之前删除缓存数据(例方法出现异常)
     */
    @CacheEvict(key = "#user.id", allEntries = true)
    public void delcache(Long id) {
        daoUser.deleteById(id);
    }
}
