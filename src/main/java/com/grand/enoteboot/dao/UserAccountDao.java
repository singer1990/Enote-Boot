package com.grand.enoteboot.dao;

import com.grand.enoteboot.entity.Permission;
import com.grand.enoteboot.entity.User;

import java.util.List;

public interface UserAccountDao {
    User findUserByUsername(String username);

    List<Permission> getMenuList(Long roleId);

    int updateByPrimaryKeySelective(User user);
}
