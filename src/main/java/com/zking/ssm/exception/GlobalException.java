package com.zking.ssm.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GlobalException implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
       ModelAndView mv = new ModelAndView();
       if(e instanceof UnauthorizedException){
                   System.out.println("无权限异常");
                   //mv.setViewName("unauthorized");
           mv.addObject("msg","无权限异常");
           mv.addObject("success","false");
       }else if(e instanceof BusinessException){
           mv.addObject("msg",e.getMessage());
           mv.addObject("success",false);
       }else {
           mv.addObject("msg","系统异常");
           mv.addObject("success",true);
       }
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }
}
