package com.binzikeji.spring.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description
 * @Author Bin
 * @Date 2019/6/7 19:19
 **/
@Controller
@RequestMapping(value = "a")
public class UserController {

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(){
        return "user/add";
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String update(){
        return "user/update";
    }
}
