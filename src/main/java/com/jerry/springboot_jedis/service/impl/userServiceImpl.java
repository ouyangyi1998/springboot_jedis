package com.jerry.springboot_jedis.service.impl;

import com.jerry.springboot_jedis.dao.UserDao;
import com.jerry.springboot_jedis.entity.User;
import com.jerry.springboot_jedis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class userServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
