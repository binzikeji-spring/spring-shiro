package com.binzikeji.spring.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author Bin
 * @Date 2019/6/7 19:40
 **/
@Controller
public class LoginController {

    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String Login(){
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String Login(
            @RequestParam(value = "loginCode") String loginCode,
            @RequestParam(value = "password") String password,
            Model model
    ){

        /**
         * shiro 编写用户认证
         */
        // 获取 Subject
        Subject subject = SecurityUtils.getSubject();
        // 封装用户名密码
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginCode, password);
        // 执行登录方法
        try {
            subject.login(usernamePasswordToken);
            // 登录成功
            return "index";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            // 登录失败: 用户名不存在
            model.addAttribute("message", "用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e){
            e.printStackTrace();
            // 登录失败: 密码错误
            model.addAttribute("message", "密码错误");
            return "login";
        }
    }
}
