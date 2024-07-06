package com.tutoring.mapper;

import com.tutoring.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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

    /**
     * 根据新信息更新教师信息
     * @param teacher 教师信息
     */
    void updateTeacher(Teacher teacher);

    /**
     * 根据教师id 查询教师信息
     * @param teacherId 教师id
     * @return Teacher 返回教师信息
     */
    @Select("SELECT * FROM studenttutoring.teacher WHERE  teacherid = #{teacherId}")
    Teacher findTeacherById(@Param("teacherId") int teacherId);

    /**
     * 获取所有的教师信息
     * @return 所有的教师信息 List容器
     */
    @Select("SELECT * FROM studenttutoring.teacher")
    List<Teacher> selectAllTeachers();

    /**
     * 将指定教师的密码更改为新密码
     * @param teacherId 教师名
     * @param newPassword 新密码
     */
    @Update("UPDATE studenttutoring.teacher SET teacherpassword = #{newPassword} WHERE teacherid = #{teacherId}")
    void updateTeacherPassword(@Param("teacherId") int teacherId, @Param("newPassword") String newPassword);
}
