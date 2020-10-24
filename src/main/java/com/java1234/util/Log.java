package com.java1234.util;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;


@Aspect
@Component
@Log4j
public class Log {

    @Pointcut("execution(* com.java1234.service.impl.*.*(..))")
    public void qie(){

    };
    @Around("qie()")
    public Object anyMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodname = joinPoint . getSignature() . getName();
        String classname=joinPoint.getTarget().getClass().getSimpleName();
        Object[] args = joinPoint . getArgs();
        Object result=joinPoint.proceed();
        LocalDateTime time= LocalDateTime.now();
        log.debug(time+":调用了"+classname+"类的" +methodname+"方法，传入的参数为: "+ Arrays. toString(args)+"方法的返回值为:"+result);
        return result;
    }
}
