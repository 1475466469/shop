package com.shop.shop.shiro;





import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ShiroUser  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键ID
     */
    private Long id;

    /**
     * 账号
     */
    private String account;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 微信openid
     */
    private String openid;

    /**
     * 部门id
     */
    private Long deptId;

    /**
     * 角色集
     */
    private List<Long> roleList;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 角色名称集
     */
    private List<String> roleNames;


}
