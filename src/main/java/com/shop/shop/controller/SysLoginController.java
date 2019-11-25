package com.shop.shop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SysLoginController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public  String login(ModelMap map){
         return "login";

    }




}
