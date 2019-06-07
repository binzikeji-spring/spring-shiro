package com.binzikeji.spring.shiro.service;

import com.binzikeji.spring.shiro.domain.TbPermission;

import java.util.List;

public interface TbPermissionService{

    List<TbPermission> selectById(Long userId);
}
