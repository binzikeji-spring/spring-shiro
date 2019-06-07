package com.binzikeji.spring.shiro.mapper;

import com.binzikeji.spring.shiro.domain.TbPermission;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface TbPermissionMapper extends MyMapper<TbPermission> {

    List<TbPermission> selectById(@Param(value = "userId") Long userId);
}