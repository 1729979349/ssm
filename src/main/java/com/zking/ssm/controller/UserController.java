package com.zking.ssm.controller;

import com.zking.ssm.model.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/userLogin")
    public ModelAndView userLogin(SysUser sysUser){
       Subject subject=  SecurityUtils.getSubject();
        UsernamePasswordToken loken  = new UsernamePasswordToken(
                sysUser.getUsername(),
                sysUser.getPassword()
        );
        String message = null;
        try {
            subject.login(loken);
        }catch (UnknownAccountException e){
          e.printStackTrace();
          message="账号错误";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            message="密码错误";
        }catch (Exception e){
            e.printStackTrace();
            message="账号或者密码错误";
        }

        ModelAndView mv = new ModelAndView();
        if(null==message){
           mv.setViewName("index");
        }else {
            mv.addObject("message",message);
            mv.setViewName("login");
        }
        return mv;
    }

    @RequestMapping("/userLogout")
    public String userLogin(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/book/index.html";
    }

}
