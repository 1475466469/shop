package com.shop.shop.service.impl;

import com.shop.shop.entity.SysUserEntity;
import com.shop.shop.repository.SysUserRepository;
import com.shop.shop.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceimpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public SysUserEntity findone(long id) {
        return  sysUserRepository.getOne(id);

    }

    @Override
    public List<SysUserEntity> findAll() {
        return sysUserRepository.findAll();
    }

    @Override
    public SysUserEntity Save(SysUserEntity sysUserEntity) throws Exception {
        return sysUserRepository.save(sysUserEntity);
    }

    @Override
    public void delete(SysUserEntity sysUserEntity) throws Exception {
        sysUserRepository.delete(sysUserEntity);
    }

    @Override
    public SysUserEntity findSysUserEntityByUserid(String userid)  {
        return sysUserRepository.findByUserid(userid);
    }


}
