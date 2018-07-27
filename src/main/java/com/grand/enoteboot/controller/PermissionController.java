package com.grand.enoteboot.controller;

import com.grand.enoteboot.entity.Permission;
import com.grand.enoteboot.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author GrandX
 */
@Controller
@RequestMapping("/permMenu")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("/init")
    public ModelAndView init(){
        ModelAndView mv = new ModelAndView("/menu/init");
        return mv;
    }

    @RequestMapping("/permissionList")
    @ResponseBody
    public List<Permission> permissionList(){
        return permissionService.getPermissionList();
    }
}
