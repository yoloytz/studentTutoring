package com.tutoring.mapper;

import com.tutoring.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
}
