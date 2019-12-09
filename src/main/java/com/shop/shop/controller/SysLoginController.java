package com.shop.shop.controller;

import com.shop.shop.entity.SysRoleEntity;
import com.shop.shop.entity.SysUserEntity;
import com.shop.shop.service.impl.SysRoleServiceimpl;
import com.shop.shop.shiro.ShiroUser;
import com.shop.shop.util.JsonUtil;
import com.shop.shop.util.RedisUtil;
import com.shop.shop.util.ResultVOUtil;
import com.shop.shop.util.ShiroKit;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SysLoginController {
        @Autowired
        private SysRoleServiceimpl sysRoleServiceimpl;

    /*登陆页面*/
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public  String login(){

        return "login";
    }


    /*主页*/
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public  String index(){

        ModelAndView mv=new ModelAndView();

      SysUserEntity sysUserEntity= ShiroKit.principal();
//      获取当前用户的所有角色

        List<SysRoleEntity> RoleList=  sysRoleServiceimpl.findAllByUserid(sysUserEntity.getId());

        for (SysRoleEntity item:RoleList){
            System.out.println(item.getRoleName());


        }


System.out.println("222");


      //  mv.addObject("userInfo",user);

            return "index";

    }

    /*登陆验证*/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "登陆方法")
    public  Object loginVali(String username, String password, String remember) throws Exception{
        try {
            if (username.equals("") || password.equals("")) {
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
        }catch (UnknownAccountException ex){
           return ResultVOUtil.error(1,ex.getMessage());

        }catch (IncorrectCredentialsException ex){
            return ResultVOUtil.error(1,ex.getMessage());
        } catch (LockedAccountException ex) {
            return ResultVOUtil.error(1, ex.getMessage());
        }
        return  ResultVOUtil.success("登陆成功");
    }







}
