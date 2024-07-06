package com.tutoring.service;

import com.tutoring.pojo.Classes;
import com.tutoring.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 云天泽 Steven
 * @version 1.0
 * Date: 2024-07-05
 * QQ：2311170320
 * 功能实现:
 */
public interface StudentService {


    /**
     * 通过用户名和密码 查询对应的用户信息
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    Student logStudent(String username,String password);

    /**
     * 根据学生Id返回所有课程信息
     * @param studentId 学生Id
     * @return 学生课程信息
     */
    List<Classes> getAllClassesInfoByStudentId(@Param("studentId") int studentId);

    /**
     * 根据学生信息 id为主键 更改对象信息
     * @param student 学生信息
     */
    void upDateStudentInfoOnView(Student student);


    /**
     * 根据课程信息增加用户需求课程
     * @param classes 课程信息
     */
    void addUserClassInfo(Classes classes);


    /**
     * 根据学生id查询学生信息
     * @param studentId 学生id
     * @return 学生信息
     */
    Student getStudentById(int studentId);
}
