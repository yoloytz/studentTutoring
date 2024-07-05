package com.tutoring.controller;

import com.tutoring.pojo.Teacher;
import com.tutoring.service.TeacherService;
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
 * 功能实现:
 */
@Controller
@RequestMapping("/Teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(path = "logTeacher",method = RequestMethod.POST)
    private ModelAndView logTeacher(String username,String password){
        ModelAndView modelAndView;
        Teacher teacher = teacherService.logTeacher(username, password);
        if(teacher != null){
            modelAndView = new ModelAndView("teacher/teacherView");
            modelAndView.addObject("teacherInfo",teacher);
            return modelAndView;
        }else {
            modelAndView = new ModelAndView("loginError");
            String errorText = username + "用户不存在或密码错误";
            modelAndView.addObject("ErrorText",errorText);
            return modelAndView;
        }
    }
}
