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
    @Query(value = "SELECT  b FROM  SysRoleMenuEntity  AS a INNER JOIN SysMenuEntity AS b ON a.menuId= b.menuId WHERE b.status=0 and b.parentId=0 and a.roleId IN (:Roles)")
    List<SysMenuEntity> findAllByRoles(@Param("Roles") List<Long> Roles);
    List<SysMenuEntity> findAllByParentId(long parentId);

}
