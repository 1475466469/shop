package com.shop.shop.controller;

import com.shop.shop.util.ShiroKit;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.awt.*;

@Controller
public class SysLoginController {



    /*登陆页面*/
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public  String login(){
         return "login";
    }


    /*主页*/
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public  String index(){

            return "index";

    }

    /*登陆验证*/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "登陆方法")
    public  String loginVali(String username, String password, String remember) throws Exception{
        if (username.equals("")|| password.equals("")) {
            throw new Exception("账号或密码为空！");
        }
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

        return  "Sssss";

    }







}
