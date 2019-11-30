package com.shop.shop.repository;

import com.shop.shop.entity.SysRoleUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysRoleUserRepository extends JpaRepository<SysRoleUserEntity,Long> {



     List<SysRoleUserEntity> findAllByUserid(long userid);
}



