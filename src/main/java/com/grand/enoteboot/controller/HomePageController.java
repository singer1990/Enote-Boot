package com.grand.enoteboot.controller;

import com.grand.enoteboot.dto.PermissionVO;
import com.grand.enoteboot.entity.User;
import com.grand.enoteboot.entity.UserRole;
import com.grand.enoteboot.service.UserService;
import com.grand.enoteboot.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author GrandX
 */
@Controller
@RequestMapping("/homepage")
public class HomePageController {
    @Autowired
    UserService userAccountService;

    @GetMapping("/init")
    public ModelAndView init(){
        ModelAndView mv = new ModelAndView("/index");
        User userAccount = SessionUtil.getSessionUser();
        Long roleId = 2L;
        if(userAccount != null){
            Long userId = userAccount.getId();
            List<UserRole> roleList = userAccountService.getUserRole(userId);
            if(!CollectionUtils.isEmpty(roleList)){
                roleId = roleList.get(0).getRoleId();
            }
        }
        List<PermissionVO> menuList = userAccountService.getMenuList(roleId);
        mv.addObject("menuList",menuList);
        return mv;
    }
    @RequestMapping(value = "/dashBoard",method = RequestMethod.GET)
    public ModelAndView dashBoard(){
        ModelAndView mv = new ModelAndView("/profile");
        return mv;
    }
}
