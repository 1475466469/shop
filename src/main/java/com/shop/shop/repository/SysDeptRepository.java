package com.shop.shop.repository;

import com.shop.shop.entity.SysDeptEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SysDeptRepository extends JpaRepository<SysDeptEntity,Long>  {



         List<Long> findAllByParentId(long id);
}
