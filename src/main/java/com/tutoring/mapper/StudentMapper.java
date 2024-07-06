package com.tutoring.mapper;

import com.tutoring.pojo.Classes;
import com.tutoring.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 云天泽 Steven
 * @version 1.0
 * Date: 2024-07-05
 * QQ：2311170320
 * 功能实现: 学生/家长与数据库信息的交互
 */
@Mapper
public interface StudentMapper {
    /**
     * 通过用户名查询学生信息
     * @param username 学生/家长 用户名
     * @return 学生信息
     */
    @Select("SELECT * FROM studenttutoring.student WHERE username = #{username}")
    Student findStudent(@Param("username") String username);

    /**
     * 在数据库中使用动态Sql语句 根据传来的学生信息id修改学生信息
     * @param student 需要更改的学生信息
     */
    void upDateUserInfo(Student student);

    /**
     * 查询数据库中对应学生id的信息
     * @param studentId 学生id
     * @return 学生信息
     */
    @Select("SELECT * FROM studenttutoring.student WHERE studentid = #{studentId}")
    Student getStudentInfobyId(int studentId);
}
