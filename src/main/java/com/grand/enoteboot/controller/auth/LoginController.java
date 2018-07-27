package com.grand.enoteboot.controller.auth;


import com.grand.enoteboot.dto.ResponseVO;
import com.grand.enoteboot.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author GrandX
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("/user/login");
    }

    @PostMapping("/submitLogin")
    @ResponseBody
    public ResponseVO submitLogin(User user, Boolean rememberMe){
        Subject subject = SecurityUtils.getSubject();
        if(rememberMe == null) {
            rememberMe = false;
        }
        AuthenticationToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword(),rememberMe);
        try {
            subject.login(token);

        }catch (AuthenticationException e){
            e.printStackTrace();
            return ResponseVO.build(500,"用户名或密码错误");
        }
        return ResponseVO.ok();
    }

    @GetMapping("/logout")
    @ResponseBody
    public ModelAndView logout(){
        Subject subject = SecurityUtils.getSubject();
        if(subject != null && subject.isAuthenticated()){
            subject.logout();
        }
        return new ModelAndView("redirect:/user/login");
    }
}
