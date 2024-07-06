package com.tutoring.service;

import com.tutoring.mapper.ClassesMapper;
import com.tutoring.mapper.TeacherMapper;
import com.tutoring.pojo.Classes;
import com.tutoring.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 云天泽 Steven
 * @version 1.0
 * Date: 2024-07-05
 * QQ：2311170320
 * 功能实现:
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private ClassesMapper classesMapper;
    /**
     * 通过教师名和密码登录 登录成功返回教师名字 失败就返回null
     *
     * @param teacherName     教师名
     * @param teacherPassword 教师密码
     * @return 返回教师信息
     */
    @Override
    public Teacher logTeacher(String teacherName, String teacherPassword) {
        Teacher teacher = teacherMapper.findTeacher(teacherName);
        if(teacher != null && teacher.getTeacherPassword().equals(teacherPassword)){
            return teacher;
        }else {
            return null;
        }
    }

    /**
     * 获取所有教师信息
     * @return 所有教师信息 List容器
     */
    @Override
    public List<Teacher> getAllTeachers() {
        return teacherMapper.selectAllTeachers();
    }

    /**
     * 通过教师id获取该教师的所有班级信息
     *
     * @param teacherId 教师id
     * @return 返回该教师的所有班级信息
     */
    @Override
    public List<Classes> getClassesByTeacherId(int teacherId) {
        return classesMapper.getAllClassesByTeacherId(teacherId);
    }

    /**
     * 教师撤单
     *
     * @param classId 要撤销的课程id
     */
    @Override
    public void teacherDeleteOrder(int classId) {
        classesMapper.teacherDeleteClass(classId);
    }

    /**
     * 将订单状态更改为老师接单
     *
     * @param classId   课程id
     * @param teacherId 教师id
     */
    @Override
    public void teacherGetOrder(int classId, int teacherId) {
        classesMapper.teacherAcceptClass(classId,teacherId);
    }

    /**
     * 教师修改密码
     *
     * @param teacherId   老师名
     * @param newPassword 新密码
     */
    @Override
    public Teacher teacherChangePassword(int teacherId, String newPassword) {
        teacherMapper.updateTeacherPassword(teacherId,newPassword);
        return teacherMapper.findTeacherById(teacherId);
    }

    /**
     * 根据教师信息更新数据库教师信息
     *
     * @param teacher 教师信息
     */
    @Override
    public Teacher upDateTeacherInfo(Teacher teacher) {
        System.out.println("测试 teacher ID xxx1" + teacher.getTeacherId());
        teacherMapper.updateTeacher(teacher);
        System.out.println("测试 teacher ID xxx2" + teacher.getTeacherId());
        return teacherMapper.findTeacherById(teacher.getTeacherId());
    }

    /**
     * 获取所有未被接单的订单
     */
    @Override
    public List<Classes> getAllOrders() {
        return classesMapper.getAllClassesOnFree();
    }
}
