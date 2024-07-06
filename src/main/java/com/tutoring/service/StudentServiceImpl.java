package com.tutoring.service;

import com.tutoring.mapper.ClassesMapper;
import com.tutoring.mapper.StudentMapper;
import com.tutoring.pojo.Classes;
import com.tutoring.pojo.Student;
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
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassesMapper classesMapper;
    @Override
    public Student logStudent(String username, String password) {
        Student student = studentMapper.findStudent(username);
        if(student != null && student.getPassword().equals(password)){
            return student;
        }else {
            return null;
        }
    }

    /**
     * 根据学生Id返回所有课程信息
     *
     * @param studentId 学生Id
     * @return 学生课程信息
     */
    @Override
    public List<Classes> getAllClassesInfoByStudentId(int studentId) {
        return classesMapper.getAllClassesByStudentId(studentId);
    }

    /**
     * 根据学生信息 id为主键 更改对象信息
     * @param student 学生信息
     */
    @Override
    public void upDateStudentInfoOnView(Student student) {
        studentMapper.upDateUserInfo(student);
    }

    /**
     * 根据课程信息增加用户需求课程
     * @param classes 课程信息
     */
    @Override
    public void addUserClassInfo(Classes classes) {
        classesMapper.insertClasses(classes);
    }

    /**
     * 根据学生id查询学生信息
     *
     * @param studentId 学生id
     * @return 学生信息
     */
    @Override
    public Student getStudentById(int studentId) {
        return studentMapper.getStudentInfobyId(studentId);
    }

    /**
     * 更改用户密码 返回更改后的用户对象
     *
     * @param newPassword 用户新密码
     * @param student     要更改的用户对象
     * @return 更改后的用户对象
     */
    @Override
    public Student updateStudentPassword(String newPassword, Student student) {
        System.out.println("新密码测试2" + newPassword);
        int studentId = student.getStudentId();
        studentMapper.updateUserPassword(studentId,newPassword);
        return studentMapper.getStudentInfobyId(studentId);
    }
    /**
     * 根据学生信息注册学生信息
     *
     * @param student 注册学生信息
     * @return 注册后返回数据库中注册成功的信息
     */
    @Override
    public Student rigStudent(Student student) {
        studentMapper.rigStudent(student);
        return studentMapper.findStudent(student.getUserName());
    }

}
