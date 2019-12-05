package com.shop.shop.service.impl;

import com.shop.shop.entity.SysRoleEntity;
import com.shop.shop.repository.SysRoleRepository;
import com.shop.shop.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysRoleServiceimpl implements SysRoleService {
    @Autowired
    private SysRoleRepository sysRoleRepository;


    @Override
    public SysRoleEntity findone(long id)  {
        return sysRoleRepository.getOne(id);
    }

    @Override
    public List<SysRoleEntity> findAll()  {
        return sysRoleRepository.findAll();
    }

    @Override
    public SysRoleEntity Save(SysRoleEntity sysRoleEntity) throws Exception {
        return sysRoleRepository.save(sysRoleEntity);
    }

    @Override
    public void delete(SysRoleEntity sysDeptEntity) throws Exception {
        sysRoleRepository.delete(sysDeptEntity);
    }

    @Override
    public List<SysRoleEntity> findAllByUserid(long id){

       return sysRoleRepository.findAllByUserid(id);
    }
}
