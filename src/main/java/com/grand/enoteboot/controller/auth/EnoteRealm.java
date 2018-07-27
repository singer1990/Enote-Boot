package com.grand.enoteboot.controller.auth;


import com.grand.enoteboot.dao.UserAccountDao;
import com.grand.enoteboot.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author GrandX
 */
@Component
public class EnoteRealm extends AuthorizingRealm {

    @Autowired
    UserAccountDao userAccountDao;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        User user = userAccountDao.findUserByUsername(username);
        if(user == null){
            return null;
        }else {
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("sessionUser",user);
            User userLoginInfo = new User();
            userLoginInfo.setId(user.getId());
            userLoginInfo.setLastLoginTime(new Date());
            userAccountDao.updateByPrimaryKeySelective(userLoginInfo);
            return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        }
    }
}
