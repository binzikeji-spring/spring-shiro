package com.binzikeji.spring.shiro.config;

import com.binzikeji.spring.shiro.domain.TbPermission;
import com.binzikeji.spring.shiro.domain.TbUser;
import com.binzikeji.spring.shiro.service.TbPermissionService;
import com.binzikeji.spring.shiro.service.TbUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Description
 * @Author Bin
 * @Date 2019/6/7 19:07
 **/
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private TbUserService tbUserService;
    @Autowired
    private TbPermissionService tbPermissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        // 给资源进行授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 添加授权字符串
        //simpleAuthorizationInfo.addStringPermission("user:add");
        Subject subject = SecurityUtils.getSubject();
        TbUser tbUser = (TbUser) subject.getPrincipal();
        List<TbPermission> tbPermissionList = tbPermissionService.selectById(tbUser.getId());
        for (TbPermission tbPermission : tbPermissionList) {
            simpleAuthorizationInfo.addStringPermission(String.format("%s:%s", "user", tbPermission.getEnname()));
        }

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        // 编写 shiro 判断业务逻辑, 判断用户名和密码
        // 判断用户名
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        List<TbUser> tbUserList = tbUserService.getByUsername(usernamePasswordToken.getUsername());
        if (tbUserList.size() != 1){
            // 用户名不存在
            return null;
        }
        TbUser tbUser = tbUserList.get(0);
        // 判断密码
        return new SimpleAuthenticationInfo(tbUser, tbUser.getPassword(), "");
    }
}
