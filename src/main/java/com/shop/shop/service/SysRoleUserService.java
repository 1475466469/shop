package com.shop.shop.service;

import com.shop.shop.entity.SysRoleUserEntity;

import java.util.List;

public interface SysRoleUserService {

    SysRoleUserEntity findone(long id);

    List<SysRoleUserEntity> findAll();

    List<SysRoleUserEntity> findAllByUserid(long userid);

    void delete(SysRoleUserEntity sysRoleUserEntity) throws Exception;




}
