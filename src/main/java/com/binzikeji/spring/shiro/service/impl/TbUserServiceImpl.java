package com.binzikeji.spring.shiro.service.impl;

import com.binzikeji.spring.shiro.domain.TbUser;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.binzikeji.spring.shiro.mapper.TbUserMapper;
import com.binzikeji.spring.shiro.service.TbUserService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class TbUserServiceImpl implements TbUserService{

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public List<TbUser> getByUsername(String username) {
        Example example = new Example(TbUser.class);
        example.createCriteria().andEqualTo("username", username);
        return tbUserMapper.selectByExample(example);
    }
}
