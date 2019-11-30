package com.shop.shop.repository;

import com.shop.shop.entity.SysRoleMenuEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysRoleMenuRepository extends JpaRepository<SysRoleMenuEntity,Long> {


   List<SysRoleMenuEntity> findAllByRoleId(long id);
}
