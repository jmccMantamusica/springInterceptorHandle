package com.interceptors.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class SpecificInterceptor implements HandlerInterceptor {


    private static final Logger LOGGER = LoggerFactory.getLogger(SpecificInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info("preHandle invoked...{}:{}", request.getRequestURI(), request.getMethod());
        return  true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOGGER.info("postHandle invoked...{}:{}", request.getRequestURI(), request.getMethod());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if(ex!=null){
            LOGGER.error("exception inside afterCompletion : {}", ex.getMessage());
        }
        LOGGER.info("afterCompletion invoked...{}:{}", request.getRequestURI(), request.getMethod());
    }
}
