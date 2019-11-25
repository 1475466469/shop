package com.shop.shop.service.impl;

import com.shop.shop.ShopApplicationTests;
import com.shop.shop.entity.SysUserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest extends ShopApplicationTests {

        @Autowired
      private UserServiceImpl userService;
     @Test
    public void  t(){
       SysUserEntity sysUserEntity= userService.findById("105463");
       System.out.println(sysUserEntity.getUserid());
    }


}