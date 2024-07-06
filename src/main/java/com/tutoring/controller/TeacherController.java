package com.tutoring.controller;

import com.tutoring.pojo.Classes;
import com.tutoring.pojo.Student;
import com.tutoring.pojo.Teacher;
import com.tutoring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    private ModelAndView logTeacher(String username, String password, HttpSession session){

        Teacher teacher = teacherService.logTeacher(username, password);
        if(teacher != null){
            session.setAttribute("currentTeacher",teacher);
            return refreshTeacherView(teacher,"欢迎您！登陆成功！");
        }else {
            ModelAndView modelAndView;
            modelAndView = new ModelAndView("loginError");
            String errorText = username + "用户不存在或密码错误";
            modelAndView.addObject("ErrorText",errorText);
            return modelAndView;
        }
    }

    @RequestMapping(path = "updateTeacherInfo",method = RequestMethod.POST)
    private ModelAndView updateTeacherInfo(@ModelAttribute Teacher teacher, HttpSession session){
        System.out.println(" 当前 Teacher = " + teacher);
        Teacher newTeacher = teacherService.upDateTeacherInfo(teacher);
        System.out.println("newTeacher = " + newTeacher);
        // 更新会话中的用户信息
        session.setAttribute("currentTeacher", newTeacher);
        return refreshTeacherView(newTeacher,"信息更新成功");
    }

    @RequestMapping(path = "deleteOrder",method = RequestMethod.POST)
    private ModelAndView teacherDeleteOrder(int orderId,HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("currentTeacher");
        teacherService.teacherDeleteOrder(orderId);
        return refreshTeacherView(teacher,"撤单成功！请勿耽误学生时间！");
    }

    @RequestMapping(path = "getOrder",method = RequestMethod.POST)
    private ModelAndView teacherGetOrder(int orderId,HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("currentTeacher");
        teacherService.teacherGetOrder(orderId, teacher.getTeacherId());
        return refreshTeacherView(teacher,"接单成功！记得按时完成哦！");
    }


    @RequestMapping(path = "changePassword",method = RequestMethod.POST)
    private ModelAndView teacherChangePassword(String newPassword,HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("currentTeacher");
        Teacher newTeacher = teacherService.teacherChangePassword(teacher.getTeacherId(),newPassword);
        session.setAttribute("currentTeacher",newTeacher);
        return refreshTeacherView(newTeacher,"密码修改成功");
    }

    @RequestMapping(path = "register",method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute Teacher teacher, HttpSession session) {
        Teacher newTeacher = teacherService.rigTeacher(teacher);
        session.setAttribute("currentTeacher", newTeacher);
        String msg = "注册成功！ "  + newTeacher.getTeacherName() + "\t 已经跳转！";
        return refreshTeacherView(newTeacher,msg);
    }


    private ModelAndView refreshTeacherView(Teacher teacher, String message){
        List<Classes> classesList = teacherService.getClassesByTeacherId(teacher.getTeacherId());
        List<Classes> allFreeOrders = teacherService.getAllOrders();
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("teacher/teacherView");
        modelAndView.addObject("teacher",teacher);
        modelAndView.addObject("freeOrders",allFreeOrders);
        modelAndView.addObject("currentOrders",classesList);
        modelAndView.addObject("message",message);
        return modelAndView;
    }
}
