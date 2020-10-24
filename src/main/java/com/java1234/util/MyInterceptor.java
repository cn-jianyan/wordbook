package com.java1234.util;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;


@Log4j

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("客户端发送了"+request.getRequestURI()+"请求，传递的参数为："+request.getParameterMap()+",映射的方法为："+handler);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // System.out.println("视图渲染后"+ex);
        LocalDateTime now=LocalDateTime.now();
        if(ex==null){

        }else{
            log.error("【"+now+"】:程序出现错误！再"+handler+"出现异常，异常信息为【"+ex.getMessage()+"】");
        }
    }

}
