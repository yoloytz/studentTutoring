package com.tutoring.service;

import com.tutoring.pojo.Classes;
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

    /**
     * 通过教师id获取该教师的所有班级信息
     * @param teacherId 教师id
     * @return 返回该教师的所有班级信息
     */
    List<Classes> getClassesByTeacherId(int teacherId);


    /**
     * 教师撤单
     * @param classId 要撤销的课程id
     */
    void teacherDeleteOrder(int classId);


    /**
     * 将订单状态更改为老师接单
     * @param classId 课程id
     * @param teacherId 教师id
     */
    void teacherGetOrder(int classId,int teacherId);


    /**
     * 教师修改密码
     * @param teacherId 老师名
     * @param newPassword 新密码
     * @return 返回修改后的教师信息
     */
    Teacher teacherChangePassword(int teacherId,String newPassword);

    /**
     * 根据教师信息更新数据库教师信息
     * @param teacher 教师信息
     * @return 返回更新后的教师信息
     */
    Teacher upDateTeacherInfo(Teacher teacher);

    /**
     * 获取所有未被接单的订单
     * @return 返回所有未被接单的订单
     */
    List<Classes> getAllOrders();

    /**
     * 注册教师
     * @param teacher 教师信息
     * @return 返回注册后的教师信息
     */
    Teacher rigTeacher(Teacher teacher);

}
