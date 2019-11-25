package com.shop.shop.service.impl;

import com.shop.shop.entity.SysUserEntity;
import com.shop.shop.repository.UserRepository;
import com.shop.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    public SysUserEntity findById(String id) {
        return userRepository.getOne(id);
    }
}
