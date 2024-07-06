package com.tutoring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @author 云天泽 Steven
 * @version 1.0
 * Date: 2024-07-05
 * QQ：2311170320
 * 功能实现: 教师实体类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {
    private int teacherId;
    /**
     * teacherName用于登录
     */
    private String teacherName;
    /**
     *  name 用于存放教师的姓名
     */
    private String name;
    private String teacherPassword;
    private int age;
    private String gender;
    private String school;
    private String state;
    private String info;
    private String tel;
}
