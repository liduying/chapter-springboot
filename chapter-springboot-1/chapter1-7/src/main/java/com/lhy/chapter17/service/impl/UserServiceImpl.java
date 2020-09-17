package com.lhy.chapter17.service.impl;

import com.lhy.chapter17.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String id , String name, Integer age) {
        jdbcTemplate.update("insert into user(id,name,age) values (?,?,?)" , id, name ,age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from USER where name = ? " , name );
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from USER",Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER");
    }
}
