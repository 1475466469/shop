package com.shop.shop.service;

import com.shop.shop.entity.SysRoleMenuEntity;

import java.util.List;

public interface SysRoleMenuService {
    SysRoleMenuEntity findone(long id);

    List<SysRoleMenuEntity> findAll();

    List<SysRoleMenuEntity> findAllByRoleId(long roleid);

    void delete(SysRoleMenuEntity sysRoleMenuEntity) throws Exception;


}
