package com.grand.enoteboot.service;

import com.grand.enoteboot.entity.Permission;

import java.util.List;

/**
 * @author GrandX
 */
public interface PermissionService {
    /**
     * @return list
     */
    List<Permission> getPermissionList();
}
