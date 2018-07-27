package com.grand.enoteboot.util;

import com.grand.enoteboot.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

public class SessionUtil {
    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }
    public static User getSessionUser(){
        Session session = SecurityUtils.getSubject().getSession();
        Object sessionUser = session.getAttribute("sessionUser");
        if(sessionUser != null){
            return (User) sessionUser;
        }else{
            return null;
        }
    }
}
