package com.binzikeji.spring.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description
 * @Author Bin
 * @Date 2019/6/7 19:22
 **/
@Controller
@RequestMapping(value = "a")
public class IndexConrtroller {

    @RequestMapping(value = {"index"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
