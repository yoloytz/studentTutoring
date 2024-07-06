package com.tutoring.service;

import com.tutoring.pojo.Teacher;

import java.util.List;

/**
 * @author 云天泽 Steven
 * @version 1.0
 * Date: 2024-07-05
 * QQ：2311170320
 * 功能实现:
 */
public interface TeacherService {
    /**
     * 通过教师名和密码登录 登录成功返回教师名字 失败就返回null
     * @param teacherName 教师名
     * @param teacherPassword 教师密码
     * @return 返回教师信息
     */
    Teacher logTeacher(String teacherName,String teacherPassword);

    /**
     * 获取所有教师信息
     * @return 所有教师信息 List容器
     */
    List<Teacher> getAllTeachers();
}
