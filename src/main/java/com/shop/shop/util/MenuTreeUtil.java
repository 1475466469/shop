package com.shop.shop.util;

import com.shop.shop.entity.SysMenuEntity;
import com.shop.shop.service.impl.SysDeptServiceimpl;
import com.shop.shop.service.impl.SysMenuServiceimpl;
import com.shop.shop.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MenuTreeUtil {



    public static Map<String,Object> mapArray=new LinkedHashMap<String,Object>();


    public List<MenuVo> menuVoList=new ArrayList<MenuVo>();

    public List<MenuVo> menuList(List<MenuVo> menu){

        for (MenuVo x : menu) {
            x.setChildrenMenu(menuChild(x.getMenuId()));
            this.menuVoList.add(x);
        }
        return  this.menuVoList;
    }

    public List<MenuVo> menuChild(long Perantid){
        List<MenuVo> lists = new ArrayList<MenuVo>();
        SysMenuServiceimpl sysMenuServiceimpl = SpringContextHolder.getBean(SysMenuServiceimpl.class);
        //根据父节点获取所有子类
      List<SysMenuEntity> list=  sysMenuServiceimpl.findAllByParentId(Perantid);

        for(SysMenuEntity item:list){
            MenuVo vo= sysMenuServiceimpl.convertToMenVo(item);
            vo.setChildrenMenu((List<MenuVo>) menuChild(vo.getMenuId()));
            lists.add(vo);
        }
        return lists;
    }



}
