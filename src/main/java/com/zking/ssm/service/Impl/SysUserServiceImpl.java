package com.zking.ssm.service.Impl;

import com.zking.ssm.mapper.SysUserMapper;
import com.zking.ssm.model.SysUser;
import com.zking.ssm.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    public SysUserMapper sysUserMapper;

    @Transactional(readOnly = true)
    @Override
    public SysUser userLogin(String username) {

        return sysUserMapper.userLogin(username);
    }

    @Override
    public Set<String> findRoles(String username) {
        return sysUserMapper.findRoles(username);
    }

    @Override
    public Set<String> findPermissions(String username) {
        return sysUserMapper.findPermissions(username);
    }
}
