package com.binzikeji.spring.shiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description
 * @Author Bin
 * @Date 2019/6/7 19:09
 **/
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier(value = "defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        /**
         * shiro过滤器
         *  anon: 无需认证登录就可以访问
         *  authc: 必须认证才可以访问
         *  user: 如果使用 rememberMe 的功能可以直接使用
         *  perms: 该资源必须得到资源权限才可以访问
         *  role: 该资源必须得到角色权限才可以访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/f/*", "anon");

        filterMap.put("/a/add", "perms[user:SystemUserInsert]");
        filterMap.put("/a/update", "perms[user:SystemUserUpdate]");

        filterMap.put("/a/*", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        shiroFilterFactoryBean.setUnauthorizedUrl("/f/noPerms");
        shiroFilterFactoryBean.setLoginUrl("/login");

        return shiroFilterFactoryBean;
    }

    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier(value = "userRealm") UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        // 关联 Realm
        defaultWebSecurityManager.setRealm(userRealm);

        return defaultWebSecurityManager;
    }

    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
