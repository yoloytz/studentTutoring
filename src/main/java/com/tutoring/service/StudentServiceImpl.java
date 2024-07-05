package com.tutoring.service;

import com.tutoring.mapper.StudentMapper;
import com.tutoring.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public Student logStudent(String username, String password) {
        Student student = studentMapper.findStudent(username);
        if(student != null && student.getPassword().equals(password)){
            return student;
        }else {
            return null;
        }
    }
}
