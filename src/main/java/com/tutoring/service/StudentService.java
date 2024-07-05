package com.tutoring.service;

import com.tutoring.pojo.Student;

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
}
