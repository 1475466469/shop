package com.shop.shop.service;


import com.shop.shop.entity.SysDeptEntity;

import java.util.List;



public interface SysDeptService {

    SysDeptEntity findone(long id)  ;

    List<SysDeptEntity> findAll();

    SysDeptEntity  Save(SysDeptEntity sysDeptEntity) throws Exception;

    void delete(SysDeptEntity sysDeptEntity) throws Exception;

    List<Long> findAllByParentId (long id) ;





}
