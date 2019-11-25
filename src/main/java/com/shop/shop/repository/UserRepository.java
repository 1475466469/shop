package com.shop.shop.repository;

import com.shop.shop.entity.SysUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<SysUserEntity,String> {



}
