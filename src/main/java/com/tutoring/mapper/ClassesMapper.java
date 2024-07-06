package com.tutoring.mapper;

import com.tutoring.pojo.Classes;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

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
     * 通过老师编号返回老师的所有课程信息
     * @param teacherId 老师编号
     * @return 该老师的所有课程信息
     */
    @Select("SELECT * FROM studenttutoring.classes WHERE classteacherid = #{teacherId}")
    List<Classes> getAllClassesByTeacherId(@Param("teacherId") int teacherId);
    /**
     * 增加课程信息 课程id自动增加 老师id设为空
     * @param classes 课程信息
     */
    void insertClasses(Classes classes);


    /**
     * 教师撤单 数据库将 订单信息里的 state改为待接单 teacherId 改为 0
     * @param classId 要撤单的课程号
     */
    @Update("UPDATE studenttutoring.classes SET classteacherid = 0,state = '待接单' WHERE classid = #{classId}")
    void teacherDeleteClass(@Param("classId") int classId);

    /**
     * 老师接单 将订单状态改变
     * @param classId 课程号
     * @param teacherId 接客老师号
     */
    @Update("UPDATE studenttutoring.classes SET state = '已接单',classteacherid = #{teacherId} WHERE classid = #{classId}")
    void teacherAcceptClass(@Param("classId") int classId, @Param("teacherId") int teacherId);
    /**
     * 获取所有未被接单的订单
     */
    @Select("SELECT * FROM studenttutoring.classes WHERE state = '待接单'")
    List<Classes> getAllClassesOnFree();


    /**
     * * 获取所有待审核的课程
     * @return 获取所有待审核的课程
     */
    @Select("SELECT * FROM studenttutoring.classes WHERE state = '待审核'")
    List<Classes> getAllClassesNoVet();

    /**
     * * 审核通过课程
     * @param classId 审核通过的课程id
     */
    @Update("UPDATE studenttutoring.classes SET state = '待接单' WHERE classid = #{classId}")
    void passTheCourse(@Param("classId") int classId);


    /**
     * * 审核不通过课程
     * @param classId 课程号
     */
    @Delete("DELETE FROM studenttutoring.classes WHERE classid = #{classId}")
    void deleteTheCourse(@Param("classId") int classId);
}
