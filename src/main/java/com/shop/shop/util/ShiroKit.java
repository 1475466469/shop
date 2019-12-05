package com.shop.shop.util;

import com.shop.shop.common.Constant;
import com.shop.shop.entity.SysUserEntity;
import com.shop.shop.enums.ShiroExceptionEnum;
import com.shop.shop.exception.ShrioException;
import com.shop.shop.repository.SysDeptRepository;
import com.shop.shop.service.impl.SysDeptServiceimpl;
import com.shop.shop.service.impl.SysRoleServiceimpl;
import com.shop.shop.service.impl.SysUserServiceimpl;
import com.shop.shop.shiro.ShiroUser;
import org.apache.commons.collections.functors.ConstantFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShiroKit {
    private static final String NAMES_DELIMETER = ",";





    /**
     * 获取当前 Subject
     *
     * @return Subject
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取封装的 ShiroUser
     *
     * @return ShiroUser
     */
    public static ShiroUser getUser() {

            return (ShiroUser) getSubject().getPrincipals().getPrimaryPrincipal();

    }

    /**
     * 获取ShiroUser，不为空的
     *
     * @return ShiroUser
     */
    public static ShiroUser getUserNotNull() throws ShrioException {
        if (isGuest()) {
            throw new ShrioException(ShiroExceptionEnum.NOT_LOGIN);
        } else {
            return (ShiroUser) getSubject().getPrincipals().getPrimaryPrincipal();
        }
    }
    /**
     * 验证当前用户是否为“访客”，即未认证（包含未记住）的用户。用user搭配使用
     *
     * @return 访客：true，否则false
     */
    public static boolean isGuest() {
        return !isUser();
    }


    /**
     * 从shiro获取session
     */
    public static Session getSession() {
        return getSubject().getSession();
    }

    /**
     * 获取shiro指定的sessionKey
     */
    @SuppressWarnings("unchecked")
    public static <T> T getSessionAttr(String key) {
        Session session = getSession();
        return session != null ? (T) session.getAttribute(key) : null;
    }

    /**
     * 设置shiro指定的sessionKey
     */
    public static void setSessionAttr(String key, Object value) {
        Session session = getSession();
        session.setAttribute(key, value);
    }

    /**
     * 移除shiro指定的sessionKey
     */
    public static void removeSessionAttr(String key) {
        Session session = getSession();
        if (session != null)
            session.removeAttribute(key);
    }

    /**
     * 验证当前用户是否属于该角色？,使用时与lacksRole 搭配使用
     *
     * @param roleName 角色名
     * @return 属于该角色：true，否则false
     */
    public static boolean hasRole(String roleName) {
        return getSubject() != null && roleName != null
                && roleName.length() > 0 && getSubject().hasRole(roleName);
    }

    /**
     * 与hasRole标签逻辑相反，当用户不属于该角色时验证通过。
     *
     * @param roleName 角色名
     * @return 不属于该角色：true，否则false
     */
    public static boolean lacksRole(String roleName) {
        return !hasRole(roleName);
    }

    /**
     * 验证当前用户是否属于以下任意一个角色。
     *
     * @param roleNames 角色列表
     * @return 属于:true,否则false
     */
    public static boolean hasAnyRoles(String roleNames) {
        boolean hasAnyRole = false;
        Subject subject = getSubject();
        if (subject != null && roleNames != null && roleNames.length() > 0) {
            for (String role : roleNames.split(NAMES_DELIMETER)) {
                if (subject.hasRole(role.trim())) {
                    hasAnyRole = true;
                    break;
                }
            }
        }
        return hasAnyRole;
    }


    /**
     * 验证当前用户是否属于以下所有角色。
     *
     * @param roleNames 角色列表
     * @return 属于:true,否则false
     */
    public static boolean hasAllRoles(String roleNames) {
        boolean hasAllRole = true;
        Subject subject = getSubject();
        if (subject != null && roleNames != null && roleNames.length() > 0) {
            for (String role : roleNames.split(NAMES_DELIMETER)) {
                if (!subject.hasRole(role.trim())) {
                    hasAllRole = false;
                    break;
                }
            }
        }
        return hasAllRole;
    }

    /**
     * 验证当前用户是否拥有指定权限,使用时与lacksPermission 搭配使用
     *
     * @param permission 权限名
     * @return 拥有权限：true，否则false
     */
    public static boolean hasPermission(String permission) {
        return getSubject() != null && permission != null
                && permission.length() > 0
                && getSubject().isPermitted(permission);
    }

    /**
     * 与hasPermission标签逻辑相反，当前用户没有制定权限时，验证通过。
     *
     * @param permission 权限名
     * @return 拥有权限：true，否则false
     */
    public static boolean lacksPermission(String permission) {
        return !hasPermission(permission);
    }

    /**
     * 已认证通过的用户。不包含已记住的用户，这是与user标签的区别所在。与notAuthenticated搭配使用
     *
     * @return 通过身份验证：true，否则false
     */
    public static boolean isAuthenticated() {
        return getSubject() != null && getSubject().isAuthenticated();
    }

    /**
     * 未认证通过用户，与authenticated标签相对应。与guest标签的区别是，该标签包含已记住用户。。
     *
     * @return 没有通过身份验证：true，否则false
     */
    public static boolean notAuthenticated() {
        return !isAuthenticated();
    }

    /**
     * 认证通过或已记住的用户。与guset搭配使用。
     *
     * @return 用户：true，否则 false
     */
    public static boolean isUser() {
        return getSubject() != null && getSubject().getPrincipal() != null;
    }


    /**
     * 输出当前用户信息，通常为登录帐号信息。
     *
     * @return 当前用户信息
     */
    public static SysUserEntity principal() {
        if (getSubject() != null) {
            Object principal = getSubject().getPrincipal();
            return (SysUserEntity)principal;
        }
       return null;
    }

    /**
     * 获取当前用户的部门数据范围的集合
     */
    public static List<Long> getDeptDataScope() throws Exception {
        Long deptId = getUser().getDeptId();
        SysDeptServiceimpl sysDeptServiceimpl = SpringContextHolder.getBean(SysDeptServiceimpl.class);
        List<Long> subDeptIds = (List<Long>) sysDeptServiceimpl.findone(deptId);
        subDeptIds.add(deptId);
        return subDeptIds;
    }

    /**
     * 判断当前用户是否是超级管理员
     */
    public static boolean isAdmin() throws Exception {
        List<Long> roleList = ShiroKit.getUser().getRoleList();
        SysRoleServiceimpl sysRoleServiceimpl = SpringContextHolder.getBean(SysRoleServiceimpl.class);
        for (Long integer : roleList) {

            String singleRoleTip = sysRoleServiceimpl.findone(integer).getRoleName();
            if (singleRoleTip.equals(Constant.SUPER_ADMIN)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 通过用户表的信息创建一个shiroUser对象
     */
    public static ShiroUser createShiroUser(SysUserEntity user) throws Exception {
        SysDeptServiceimpl sysDeptServiceimpl = SpringContextHolder.getBean(SysDeptServiceimpl.class);
        ShiroUser shiroUser = new ShiroUser();
        if (user == null) {
            return shiroUser;
        }
        shiroUser.setId(user.getId());
        shiroUser.setAccount(user.getUserid());
        shiroUser.setDeptId(user.getDeptId());
        shiroUser.setDeptName(sysDeptServiceimpl.findone(user.getDeptId()).getDeptName());
        shiroUser.setName(user.getUsername());
        shiroUser.setEmail(user.getEmail());
        shiroUser.setOpenid(user.getWeixinopenid());
        return shiroUser;
    }




}
