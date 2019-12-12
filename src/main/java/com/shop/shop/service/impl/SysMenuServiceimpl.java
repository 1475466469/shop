package com.shop.shop.service.impl;

import com.shop.shop.entity.SysMenuEntity;
import com.shop.shop.repository.SysMenuRepository;
import com.shop.shop.service.SysMenuService;
import com.shop.shop.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenuServiceimpl implements SysMenuService {


    @Autowired
    private SysMenuRepository sysMenuRepository;
    @Override
    public SysMenuEntity findone(long id) {
        return sysMenuRepository.getOne(id);
    }

    @Override
    public List<SysMenuEntity> findAll() {
        return sysMenuRepository.findAll();
    }

    @Override
    public SysMenuEntity Save(SysMenuEntity sysMenuEntity) throws Exception {
        return sysMenuRepository.save(sysMenuEntity);
    }

    @Override
    public void delete(SysMenuEntity sysMenuEntity) throws Exception {
        sysMenuRepository.delete(sysMenuEntity);
    }

    public  List<SysMenuEntity> findAllByRoles(List<Long> Roleids){
      return   sysMenuRepository.findAllByRoles(Roleids);
    }
    public  List<SysMenuEntity>  findAllByParentId(long ParentId){

        return   sysMenuRepository.findAllByParentId(ParentId);

    }

    public MenuVo convertToMenVo(SysMenuEntity item){
        MenuVo menuVo= new MenuVo();
        menuVo.setMenuId(item.getMenuId());
        menuVo.setName(item.getName());
        menuVo.setOrderNum(item.getOrderNum());
        menuVo.setParentId(item.getParentId());
        menuVo.setIcon(item.getIcon());
        menuVo.setPerms(item.getPerms());
        menuVo.setType(item.getType());
        menuVo.setUrl(item.getUrl());
        menuVo.setStatus(item.getStatus());
        return menuVo;
    }


    List<SysMenuEntity> Menulist=new ArrayList<SysMenuEntity>();
    public  List<SysMenuEntity> GetchildrenMenu(List<SysMenuEntity> Parent){
        for (SysMenuEntity menu:Parent
             ) {
            //1.找到子类
         List<SysMenuEntity> list= findAllByParentId(menu.getMenuId());
         Menulist.addAll(list);
         if(list==null&list.size()==0){
             continue;
         }else {
             GetchildrenMenu(list);
         }
        }
        return Menulist;
    }


}
