package com.shop.shop.repository;

import com.shop.shop.entity.SysRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SysRoleRepository extends JpaRepository<SysRoleEntity, Long> {



  /* 根据用户id获取所有的角色*/


    @Query(value = "SELECT  d.* FROM  sys_user AS a INNER JOIN sys_role_user AS b ON a.`id`=b.`userid` LEFT JOIN sys_role_dept AS c ON a.`dept_id`=c.`dept_id` LEFT JOIN sys_role AS d ON b.`role_id`=d.`role_id` AND c.`role_id`=d.`role_id` WHERE a.id=:id",nativeQuery = true)
    List<SysRoleEntity> findAllByUserid(long id);



}
