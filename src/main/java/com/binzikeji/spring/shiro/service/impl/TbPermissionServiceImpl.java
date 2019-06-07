package com.binzikeji.spring.shiro.service.impl;

import com.binzikeji.spring.shiro.domain.TbPermission;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.binzikeji.spring.shiro.mapper.TbPermissionMapper;
import com.binzikeji.spring.shiro.service.TbPermissionService;

import java.util.List;

@Service
public class TbPermissionServiceImpl implements TbPermissionService{

    @Resource
    private TbPermissionMapper tbPermissionMapper;

    @Override
    public List<TbPermission> selectById(Long userId) {
        return tbPermissionMapper.selectById(userId);
    }
}
