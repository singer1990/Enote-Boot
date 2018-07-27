package com.grand.enoteboot.service.impl;

import com.grand.enoteboot.dao.PermissionDao;
import com.grand.enoteboot.entity.Permission;
import com.grand.enoteboot.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GrandX
 */
@Service
public class PermissionServiceImpl implements PermissionService{
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> getPermissionList() {
       return permissionDao.findAll();
    }
}
