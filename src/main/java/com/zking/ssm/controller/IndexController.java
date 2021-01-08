package com.zking.ssm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
//@RequestMapping("index")
public class IndexController {

    @RequestMapping("/book/index.html")
    public String toIndex(HttpSession session){
        ///WEB-INF/jsp/+index+.jsp
        session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.CHINA);
        return "login";
    }

    @RequestMapping("ChengLocale")
    public String Locale(HttpSession session,String type){
        if(type.equals("zh"))
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.CHINA);
        else if(type.equals("us"))
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.US);
        else
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.JAPAN);

        return "index";
    }

//    @RequestMapping(value = "bookAdd",method = RequestMethod.POST)
    @RequestMapping("books")
    public String bookAdd(){
        System.out.println("这是Index的Bookadd方法");
        return "/book/bookAdd";
    }


}
