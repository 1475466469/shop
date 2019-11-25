package com.shop.shop.repository;

import com.shop.shop.ShopApplicationTests;
import com.shop.shop.entity.SysUserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest extends ShopApplicationTests {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void Save() {
        SysUserEntity user =new SysUserEntity();
        user.setUserid("105463");
        user.setUsername("11110");
        user.setStatus((byte) 0);
        user.setPassword("12212");
        user.setDeptId((long) 10);
        user.setEmail("1475466469@qq.com");
        user.setMobile("15270557476");
        user.setCreateDate(new Timestamp(System.currentTimeMillis()));
        user.setCreateIp("214.1.1154");
        userRepository.save(user);

        System.out.println(user.toString());

    }


}