package com.grand.enoteboot.interceptor;

import com.grand.enoteboot.entity.User;
import com.grand.enoteboot.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author GrandX
 */
public class LogInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Value("${static.url}")
    private String staticUrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Long startTime = System.currentTimeMillis();
        request.getSession().setAttribute("startTime",startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        if(modelAndView != null){
            modelAndView.addObject("staticUrl",staticUrl);
            User userAccount = SessionUtil.getSessionUser();
            modelAndView.addObject("userAccount",userAccount);
        }
        Long endTime = System.currentTimeMillis();
        if(request.getSession().getAttribute("startTime") != null) {
            Long consumeTime = endTime - (Long)request.getSession().getAttribute("startTime");
            logger.info("请求路径:"+request.getRequestURI()+"---处理时间:"+consumeTime+"ms");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
