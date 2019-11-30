package com.shop.shop.service.impl;

import com.shop.shop.entity.SysRoleMenuEntity;
import com.shop.shop.repository.SysRoleMenuRepository;
import com.shop.shop.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleMenuServiceimpl implements SysRoleMenuService {
    @Autowired
    private SysRoleMenuRepository sysRoleMenuRepository;


    @Override
    public SysRoleMenuEntity findone(long id) {
        return sysRoleMenuRepository.getOne(id);
    }

    @Override
    public List<SysRoleMenuEntity> findAll() {
        return sysRoleMenuRepository.findAll();
    }

    @Override
    public List<SysRoleMenuEntity> findAllByRoleId(long roleid) {

        return sysRoleMenuRepository.findAllByRoleId(roleid);
    }

    @Override
    public void delete(SysRoleMenuEntity sysRoleMenuEntity) throws Exception {
        sysRoleMenuRepository.delete(sysRoleMenuEntity);
    }
}
