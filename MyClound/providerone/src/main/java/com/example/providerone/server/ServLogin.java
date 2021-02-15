package com.example.providerone.server;

import com.example.providerone.ctrl.iface.ILogin;
import com.example.providerone.dao.DaoUser;
import com.example.providerone.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建时间:2021/2/11
 * 创建人:pmc
 * 描述:
 */
@Service
public class ServLogin implements ILogin<User> {
    @Autowired
    private DaoUser daoUser;
    @Autowired
    private ValueOperations<String, Object> valueOperations;//string
    @Autowired
    private HashOperations<String, String, Object> hashOperations;//hash


    @Override
    public String in(String name, String psd) {
        return null;
    }

    @Override
    public List<User> list() {
        List<User> list = daoUser.findAll();
        Map<String, Object> map = hashOperations.entries("user");
        if (map.size() > 0) {
            User user = new User();
            user.setId((int) map.get("id"));
            user.setName(map.get("name").toString());
            user.setSex((map.get("sex").toString()));
            list.add(user);
        }
        return list;
    }

    @Override
    public void add(User user) {
        daoUser.save(user);
    }

    @Override
    public void delete(User user) {
        daoUser.delete(user);
    }

    @Override
    public void update(User user) {
        daoUser.save(user);
    }

    @Override
    public void addCache(User user) {
        valueOperations.set("id", user.getId());
        valueOperations.set("name", user.getName());
        valueOperations.set("sex", user.getSex());
        Map<String, Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("name", user.getName());
        map.put("sex", user.getSex());
        hashOperations.putAll("user", map);
    }

}
