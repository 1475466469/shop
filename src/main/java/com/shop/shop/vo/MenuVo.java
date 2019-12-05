package com.shop.shop.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MenuVo implements Serializable {
    private static final long serialVersionUID = 1L;
   /* 菜单id*/
    private long menuId;
    /*父节点id*/
    private Long parentId;
    /*菜单名*/
    private String name;

    private String url;
    /*权限*/
    private String perms;
   /* 类型 0.目录 1.菜单 2.按钮*/
    private Integer type;

    private String icon;

    private Integer orderNum;
//    状态 0.可用 1.禁用
    private Integer status;

    private List<MenuVo> childrenMenu;

}
