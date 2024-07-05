package com.tutoring.controller;

import com.tutoring.pojo.Student;
import com.tutoring.service.StudentService;
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
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "logStudent",method = RequestMethod.POST)
    private ModelAndView logStudent(String username,String password){
        ModelAndView modelAndView;
        Student student = studentService.logStudent(username,password);
        if(student != null){
            modelAndView = new ModelAndView("user/userView");
            modelAndView.addObject("userInfo",student);
            return modelAndView;
        }else {
            modelAndView = new ModelAndView("loginError");
            String errorText = username + "用户不存在或密码错误";
            modelAndView.addObject("ErrorText",errorText);
            return modelAndView;
        }
    }
}
