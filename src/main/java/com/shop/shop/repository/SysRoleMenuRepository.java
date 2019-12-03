package com.shop.shop.repository;

import com.shop.shop.entity.SysRoleMenuEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SysRoleMenuRepository extends JpaRepository<SysRoleMenuEntity,Long> {


   List<SysRoleMenuEntity> findAllByRoleId(long id);

//   获取所有权限



      @Query(value = "SELECT g.perms FROM sys_user AS a INNER JOIN  sys_role_user AS b ON a.id=b.userid INNER JOIN sys_role_menu AS d ON b.role_id=d.role_id INNER JOIN sys_menu AS g ON d.menu_id=g.menu_id WHERE a.id= ?1",nativeQuery = true)
       List<String> findPermsByUserid(@Param("id") long id);


}
