package com.grand.enoteboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author GrandX
 */
@Controller
@RequestMapping(value = "/error",method = RequestMethod.GET)
public class ErrorUrlController implements ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(ErrorUrlController.class);

    @Override
    public String getErrorPath() {
        logger.info("出错啦！进入自定义错误控制器");
        return "/error/404";
    }

    @RequestMapping
    public String error() {
        return getErrorPath();
    }
}
