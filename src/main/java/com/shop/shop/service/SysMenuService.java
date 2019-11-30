package com.shop.shop.service;

import com.shop.shop.entity.SysMenuEntity;

import java.util.List;

public interface SysMenuService {

    SysMenuEntity findone(long id)  ;

    List<SysMenuEntity> findAll() ;

    SysMenuEntity  Save(SysMenuEntity sysMenuEntity) throws Exception;

    void delete(SysMenuEntity sysMenuEntity) throws Exception;

}
