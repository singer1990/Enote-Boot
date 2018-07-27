package com.grand.enoteboot.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author GrandX
 */
@Aspect
@Component
public class DataLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(DataLogAspect.class);

    @Pointcut("@annotation(com.grand.enoteboot.annotation.AddLog)")
    public void addLog(){}

    @AfterReturning("addLog()")
    public Object addOperateLog(){
        Object result = null;
        try {
            System.out.println("before addLog");
            result = "success";
        }catch (Throwable e){
            e.getMessage();
            throw e;
        }finally {
            System.out.println("finally addLog");
        }
        return result;
    }
}
