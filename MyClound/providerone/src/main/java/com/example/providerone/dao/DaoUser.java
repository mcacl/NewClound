package com.example.providerone.dao;

import com.example.providerone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * 创建时间:2021/2/11
 * 创建人:pmc
 * 描述:
 */
public interface DaoUser extends JpaRepository<User,Long> {

}
