package com.tutoring.controller;

import com.tutoring.pojo.Classes;
import com.tutoring.pojo.Student;
import com.tutoring.pojo.Teacher;
import com.tutoring.service.StudentService;
import com.tutoring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    /**
     * 根据账号密码登录
     * @param username 账号
     * @param password 密码
     * @return 登录成功返回学生页面，失败返回错误页面
     */
    @RequestMapping(path = "logStudent",method = RequestMethod.POST)
    private ModelAndView logStudent(String username,String password, HttpSession session){
        Student student = studentService.logStudent(username,password);
        if(student != null){
            session.setAttribute("currentUser", student);
            return refreshView(student);
        }else {
            ModelAndView modelAndView;
            modelAndView = new ModelAndView("loginError");
            String errorText = username + "用户不存在或密码错误";
            modelAndView.addObject("ErrorText",errorText);
            return modelAndView;
        }
    }

    /**
     * 修改学生信息 刷新学生页面
     * @param student 学生信息
     * @return 学生页面
     */
    @RequestMapping(path = "updateUserInfo",method = RequestMethod.POST)
    private ModelAndView updateUserInfo(@ModelAttribute Student student, HttpSession session){
        studentService.upDateStudentInfoOnView(student);
        // 从会话中检索当前用户信息
        // 从数据库中重新获取最新的用户信息
        Student updatedStudent = studentService.getStudentById(student.getStudentId());
        // 更新会话中的用户信息
        session.setAttribute("currentUser", updatedStudent);
        return refreshView(updatedStudent);
    }

    /**
     根据传来的学生信息刷新UserView页面
     */
    private ModelAndView refreshView(Student student){
        ModelAndView modelAndView;
        List<Teacher> allTeachers = teacherService.getAllTeachers();
        List<Classes> studentClasses = studentService.getAllClassesInfoByStudentId(student.getStudentId());
        modelAndView = new ModelAndView("user/userView");
        modelAndView.addObject("user",student);
        modelAndView.addObject("allTeachers",allTeachers);
        modelAndView.addObject("studentClasses",studentClasses);
        return modelAndView;
    }


    /**
     * 增加课程信息并刷新
     * @param classInfo 更改的课程信息
     * @param session 学生信息
     * @return 刷新页面
     */
    @RequestMapping(path = "submitOrder",method = RequestMethod.POST)
    private ModelAndView submitOrder(@ModelAttribute Classes classInfo, HttpSession session){
        studentService.addUserClassInfo(classInfo);
        // 从会话中检索当前用户信息
        Student currentUser = (Student) session.getAttribute("currentUser");
        return refreshView(currentUser);
    }

    //退出登录
    //修改密码
}
