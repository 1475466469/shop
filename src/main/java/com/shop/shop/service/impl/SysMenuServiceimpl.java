package com.shop.shop.service.impl;

import com.shop.shop.entity.SysMenuEntity;
import com.shop.shop.repository.SysMenuRepository;
import com.shop.shop.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceimpl implements SysMenuService {
    @Autowired
    private SysMenuRepository sysMenuRepository;
    @Override
    public SysMenuEntity findone(long id) {
        return sysMenuRepository.getOne(id);
    }

    @Override
    public List<SysMenuEntity> findAll() {
        return sysMenuRepository.findAll();
    }

    @Override
    public SysMenuEntity Save(SysMenuEntity sysMenuEntity) throws Exception {
        return sysMenuRepository.save(sysMenuEntity);
    }

    @Override
    public void delete(SysMenuEntity sysMenuEntity) throws Exception {
        sysMenuRepository.delete(sysMenuEntity);
    }
}
