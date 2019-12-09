package com.shop.shop.repository;

import com.shop.shop.entity.SysRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SysRoleRepository extends JpaRepository<SysRoleEntity, Long> {



  /* 根据用户id获取所有的角色*/


   @Query(value = "SELECT c  FROM  SysUserEntity a LEFT JOIN SysRoleUserEntity  b ON a.id=b.roleId LEFT JOIN SysRoleEntity c ON b.roleId=c.roleId LEFT JOIN SysRoleDeptEntity  d ON a.deptId=d.deptId AND c.roleId=d.roleId WHERE a.id=:id")
    List<SysRoleEntity> findAllByUserid(@Param("id") long id);



}
