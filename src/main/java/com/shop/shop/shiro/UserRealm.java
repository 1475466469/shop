package com.shop.shop.shiro;

import com.shop.shop.common.Constant;
import com.shop.shop.entity.SysMenuEntity;
import com.shop.shop.entity.SysUserEntity;
import com.shop.shop.service.impl.SysMenuServiceimpl;
import com.shop.shop.service.impl.SysUserServiceimpl;
import com.shop.shop.util.ShiroKit;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm  extends AuthorizingRealm
{


    @Autowired
    private SysUserServiceimpl sysUserServiceimpl;
    @Autowired
    private SysMenuServiceimpl sysMenuServiceimpl;

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }



    /**
     * 认证(登录时调用)
     */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
//        查询用户信息
      SysUserEntity sysUserEntity= sysUserServiceimpl.findSysUserEntityByUserid(username);

      //账号不存在
      if(sysUserEntity==null){
          throw new UnknownAccountException("账号或密码不正确");
      }
      if(!password.equals(sysUserEntity.getPassword())){
          throw new IncorrectCredentialsException("账号或密码不正确");
      }
      if(sysUserEntity.getStatus()==0){
          throw new LockedAccountException("账号已被锁定,请联系管理员");
      }

        ShiroKit.setSessionAttr(Constant.CURRENT_USER,sysUserEntity);
        List<String> permsList = null;
        if(Constant.CURRENT_USER==sysUserEntity.getUserid()){   //=如果是管理员
              List<SysMenuEntity> sysMenuEntityList=  sysMenuServiceimpl.findAll();
            for (SysMenuEntity menuEntity: sysMenuEntityList) {
                permsList.add(menuEntity.getPerms());
            }



        }







        return null;
    }
}
