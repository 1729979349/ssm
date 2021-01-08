package com.zking.ssm.service;

import com.zking.ssm.model.SysUser;
import org.springframework.stereotype.Repository;

import java.util.Set;

public interface ISysUserService {


    /**
     * 用户登录
     * @param username
     * @return
     */
    SysUser userLogin(String username);

    /*
根据username查询该用户的所有角色，用于角色验证
 */

    Set<String> findRoles(String username);

    /*
    根据username查询他所拥有的权限信息，用于权限判断
     */
    Set<String> findPermissions(String username);
}