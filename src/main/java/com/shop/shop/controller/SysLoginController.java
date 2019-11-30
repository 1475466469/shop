package com.shop.shop.controller;

import com.shop.shop.util.ShiroKit;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SysLoginController {



    /*登陆页面*/
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public  String login(){
         return "login";
    }

    /*登陆验证*/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public  String loginVali(String username, String password, String remember){
        Subject currentUser = ShiroKit.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username.trim(), password.trim().toCharArray());
        //如果开启了记住我功能
        if ("on".equals(remember)) {
            token.setRememberMe(true);
        } else {
            token.setRememberMe(false);
        }
        //执行shiro登录操作
        currentUser.login(token);

        return "11";

    }







}
