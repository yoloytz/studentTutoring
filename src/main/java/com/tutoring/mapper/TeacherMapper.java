package com.tutoring.mapper;

import com.tutoring.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 云天泽 Steven
 * @version 1.0
 * Date: 2024-07-05
 * QQ：2311170320
 * 功能实现:
 */
@Mapper
public interface TeacherMapper {
    /**
     * 根据教师名 查询教师信息
     * @param teacherName 教师名
     * @return Teacher 返回教师信息
     */
    @Select("SELECT * FROM studenttutoring.teacher WHERE  teachername = #{teacherName}")
    Teacher findTeacher(@Param("teacherName") String teacherName);
}
