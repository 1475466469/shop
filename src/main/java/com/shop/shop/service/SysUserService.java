package com.shop.shop.service;

import com.shop.shop.entity.SysUserEntity;

import java.util.List;

public interface SysUserService  {


       SysUserEntity findone(long id);

       List<SysUserEntity> findAll() ;

       SysUserEntity  Save(SysUserEntity sysUserEntity) throws Exception;

       void delete(SysUserEntity sysUserEntity) throws Exception;

       SysUserEntity findSysUserEntityByUserid(String userid);





}
