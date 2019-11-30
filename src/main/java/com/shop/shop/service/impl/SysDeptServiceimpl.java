package com.shop.shop.service.impl;

import com.shop.shop.entity.SysDeptEntity;
import com.shop.shop.repository.SysDeptRepository;
import com.shop.shop.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysDeptServiceimpl implements SysDeptService {

        @Autowired
        private SysDeptRepository sysDeptRepository;

    @Override
    public SysDeptEntity findone(long id)  {
        return sysDeptRepository.getOne(id);
    }

    @Override
    public List<SysDeptEntity> findAll()  {
        return sysDeptRepository.findAll();
    }

    @Override
    public SysDeptEntity Save(SysDeptEntity sysDeptEntity) throws Exception {
        return sysDeptRepository.save(sysDeptEntity);
    }

    @Override
    public void delete(SysDeptEntity sysDeptEntity) throws Exception {
            sysDeptRepository.delete(sysDeptEntity);
    }

    @Override
    public List<Long> findAllByParentId(long id) {
        return sysDeptRepository.findAllByParentId(id);
    }
}
