package com.shop.shop.service;

import com.shop.shop.entity.SysUserEntity;

import java.util.Optional;

public interface UserService {

    SysUserEntity findById(String id);

}
