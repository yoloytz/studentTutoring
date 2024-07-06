package com.tutoring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 云天泽 Steven
 * @version 1.0
 * Date: 2024-07-05
 * QQ：2311170320
 * 功能实现: 学生实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private int studentId;
    private String name;
    private String userName;
    private String password;
    private int age;
    private String school;
    private String info;
    private String tel;
    private String gender;
}
