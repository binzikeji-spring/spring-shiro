package com.binzikeji.spring.shiro.service;

import com.binzikeji.spring.shiro.domain.TbUser;

import java.util.List;

public interface TbUserService{

    public List<TbUser> getByUsername(String username);
}
