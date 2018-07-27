package com.grand.enoteboot.dao;

import com.grand.enoteboot.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
}
