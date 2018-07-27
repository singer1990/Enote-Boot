package com.grand.enoteboot.service;


import com.grand.enoteboot.dto.PermissionVO;
import com.grand.enoteboot.entity.User;
import com.grand.enoteboot.entity.UserRole;

import java.util.List;

/**
 * @author GrandX
 */
public interface UserService {
    List<UserRole> getUserRole(Long userId);

    List<PermissionVO> getMenuList(Long roleId);

    User findUserByUsername(String username);
}
