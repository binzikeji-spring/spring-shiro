package com.binzikeji.spring.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description
 * @Author Bin
 * @Date 2019/6/7 22:09
 **/
@Controller
@RequestMapping(value = "f")
public class NoPerms {

    @RequestMapping(value = "noPerms", method = RequestMethod.GET)
    public String noPerms(){
        return "noPerms";
    }
}
