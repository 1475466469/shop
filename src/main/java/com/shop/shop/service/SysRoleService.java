package com.shop.shop.service;

import com.shop.shop.entity.SysRoleEntity;

import java.util.List;

public interface SysRoleService {

    SysRoleEntity findone(long id)  ;

    List<SysRoleEntity> findAll() ;

    SysRoleEntity  Save(SysRoleEntity sysRoleEntity) throws Exception;

    void delete(SysRoleEntity sysDeptEntity) throws Exception;

    List<SysRoleEntity> findAllByUserid(long id);



}
