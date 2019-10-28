package com.jerry.springboot_jedis.dao;

import com.jerry.springboot_jedis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDao extends PagingAndSortingRepository<User,Long>, JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
    User findById(String id);
}
