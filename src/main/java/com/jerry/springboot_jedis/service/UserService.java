package com.jerry.springboot_jedis.service;

import com.jerry.springboot_jedis.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User findById(String id);
    void delete(User user);
    List<User> findAll();
}
