package com.shop.shop.repository;

import com.shop.shop.entity.SysMenuEntity;
import com.shop.shop.vo.MenuVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.xml.bind.ValidationEvent;
import java.util.List;

public interface SysMenuRepository extends JpaRepository<SysMenuEntity, Long> {

    /*根据角色获取菜单*/

    @Query(value = "SELECT  b.* FROM  sys_role_menu a INNER JOIN sys_menu AS b ON a.menu_id= b.menu_id WHERE a.role_id IN (:Roles)",nativeQuery = true)
    List<MenuVo> findAllByRoles(@Param("Roles") List<Integer> Roles);


}
