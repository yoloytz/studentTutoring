package com.tutoring.mapper;

import com.tutoring.pojo.Classes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 云天泽 Steven
 * @version 1.0
 * Date: 2024-07-06
 * QQ：2311170320
 * 功能实现:
 */
@Mapper
public interface ClassesMapper {

    /**
     * 通过学生编号返回学生的所有 课程信息
     * @param studentId 学生编号
     * @return 该学生的所有课程信息
     */
    @Select("SELECT * FROM studenttutoring.classes WHERE classstudentid = #{studentId}")
    List<Classes> getAllClassesByStudentId(@Param("studentId") int studentId);

    /**
     * 增加课程信息 课程id自动增加 老师id设为空
     * @param classes 课程信息
     */
    void insertClasses(Classes classes);
}
