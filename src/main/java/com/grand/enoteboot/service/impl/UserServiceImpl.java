package com.grand.enoteboot.service.impl;

import com.grand.enoteboot.dao.UserAccountDao;
import com.grand.enoteboot.dao.UserRoleDao;
import com.grand.enoteboot.dto.PermissionVO;
import com.grand.enoteboot.entity.Permission;
import com.grand.enoteboot.entity.User;
import com.grand.enoteboot.entity.UserRole;
import com.grand.enoteboot.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author GrandX
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserAccountDao userAccountDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public User findUserByUsername(String username) {
        User user = userAccountDao.findUserByUsername(username);
        return user;
    }

    @Override
    public List<UserRole> getUserRole(Long userId) {
        return userRoleDao.selectByUserId(userId);
    }

    @Override
    public List<PermissionVO> getMenuList(Long roleId) {
        List<Permission> menuList = userAccountDao.getMenuList(roleId);
        List<PermissionVO> permissionVOList = new ArrayList<>();
        for (Permission perm : menuList) {
            // 是否是父节点
            if(perm.getIsLeaf() == 0){
                // 找到其子节点并存入集合
                List<PermissionVO> childrenList = new ArrayList<>();
                for (Permission permLeaf : menuList) {
                    if (Objects.equals(permLeaf.getParentId(), perm.getId())) {
                        PermissionVO child = new PermissionVO();
                        BeanUtils.copyProperties(permLeaf,child);
                        childrenList.add(child);
                    }
                }
                PermissionVO parent = new PermissionVO();
                BeanUtils.copyProperties(perm,parent);
                // 将子节点集合存入
                parent.setChildren(childrenList);
                permissionVOList.add(parent);
            }
        }
        return permissionVOList;
    }

}