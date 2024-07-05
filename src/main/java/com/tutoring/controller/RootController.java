package com.tutoring.controller;

import com.tutoring.pojo.Root;
import com.tutoring.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 云天泽 Steven
 * @version 1.0
 * Date: 2024-07-05
 * QQ：2311170320
 * 功能实现:处理前端传来的数据请求 ，调用服务控制用户行为。
 */

@Controller
@RequestMapping("/root")
public class RootController {
    @Autowired
    private RootService rootService;
    @RequestMapping(path = "logRoot",method = RequestMethod.POST)
    private ModelAndView logRoot(String username,String password){
        Root root = rootService.logRoot(username,password);
        ModelAndView modelAndView;
        if(root != null){
            modelAndView = new ModelAndView("root/rootView");
            modelAndView.addObject("RootInfo",root);
        }else {
            modelAndView = new ModelAndView("loginError");
            String errorText = username + "不存在或密码错误";
            modelAndView.addObject("ErrorText",errorText);
        }
        return modelAndView;
    }
}
