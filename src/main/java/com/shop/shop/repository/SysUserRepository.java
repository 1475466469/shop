package com.shop.shop.repository;

import com.shop.shop.entity.SysUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.geom.QuadCurve2D;
import java.util.List;
import java.util.Optional;



public interface SysUserRepository  extends JpaRepository<SysUserEntity, Long> {

    SysUserEntity findSysUserEntityByUserid(String username);
}
