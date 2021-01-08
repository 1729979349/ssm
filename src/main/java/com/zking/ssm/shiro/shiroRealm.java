package com.zking.ssm.shiro;

import com.zking.ssm.model.SysUser;
import com.zking.ssm.service.ISysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class shiroRealm extends AuthorizingRealm {

    @Autowired
    public ISysUserService sysUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String username = principalCollection.getPrimaryPrincipal().toString();
        Set<String> roles = sysUserService.findRoles(username);
        Set<String> permissions = sysUserService.findPermissions(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }



    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

     String username =  authenticationToken.getPrincipal().toString();
     String password =   authenticationToken.getCredentials().toString();

     SysUser sysUser =   sysUserService.userLogin(username);
        System.out.println("17263871263812312"+sysUser);
       if(null==sysUser)
           throw new UnknownAccountException("账号错误");

           SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                   sysUser.getUsername(),
                   sysUser.getPassword(),
                   ByteSource.Util.bytes(sysUser.getSalt()),
                   this.getName()
           );
 
        return simpleAuthenticationInfo;
    }
}
