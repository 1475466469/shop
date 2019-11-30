package com.shop.shop.service.impl;


import com.shop.shop.entity.SysRoleUserEntity;
import com.shop.shop.repository.SysRoleUserRepository;
import com.shop.shop.service.SysRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleUserServiceimpl implements SysRoleUserService {
    @Autowired
    private SysRoleUserRepository sysRoleUserRepository;


    @Override
    public SysRoleUserEntity findone(long id) {
        return sysRoleUserRepository.getOne(id);
    }

    @Override
    public List<SysRoleUserEntity> findAll() {
        return sysRoleUserRepository.findAll();
    }

    @Override
    public List<SysRoleUserEntity> findAllByUserid(long userid) {
        return sysRoleUserRepository.findAllByUserid(userid);
    }

    @Override
    public void delete(SysRoleUserEntity sysRoleUserEntity) throws Exception {
            sysRoleUserRepository.delete(sysRoleUserEntity);
    }
}
