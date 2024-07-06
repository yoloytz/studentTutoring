package com.tutoring.controller;

import com.tutoring.pojo.Classes;
import com.tutoring.pojo.Root;
import com.tutoring.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    private ModelAndView logRoot(String username,String password, HttpSession session){
        Root root = rootService.logRoot(username,password);
        if(root != null){
            session.setAttribute("currentRoot",root);
            return refreshRootView("管理员您好！登录成功",root);
        }else {
            ModelAndView modelAndView;
            modelAndView = new ModelAndView("loginError");
            String errorText = username + "管理员不存在或密码错误";
            modelAndView.addObject("ErrorText",errorText);
            return modelAndView;
        }

    }

    private ModelAndView refreshRootView(String message,Root root){
        List<Classes> classesList = rootService.getAllClassesNoVet();
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("root/rootView");
        modelAndView.addObject("admin",root);
        modelAndView.addObject("classesList",classesList);
        modelAndView.addObject("message",message);
        return modelAndView;
    }

    @PostMapping("approveOrder")
    public ModelAndView approveOrder(@RequestParam("classId") int classId,HttpSession session) {
        rootService.vetClass(classId);
        String message = "已批准" + classId + "号课程 ！ ";;
        return refreshRootView(message, (Root) session.getAttribute("currentRoot"));
    }

    @PostMapping("deleteOrder")
    public ModelAndView deleteOrder(@RequestParam("classId") int classId,HttpSession session) {
        rootService.deleteClass(classId);
        String message = "已删除" + classId + "号课程 ！ ";;
        return refreshRootView(message, (Root) session.getAttribute("currentRoot"));
    }
}
