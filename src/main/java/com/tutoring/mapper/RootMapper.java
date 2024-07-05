package com.tutoring.mapper;

import com.tutoring.pojo.Root;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 云天泽 Steven
 * @version 1.0
 * Date: 2024-07-05
 * QQ：2311170320
 * 功能实现: 管理员DAO 用于管理员数据与数据库的交互
 */
@Mapper
public interface RootMapper {
    /**
     * 通过用户名插叙对象信息
     * @param username 用户名
     * @return Root 返回对象信息
     */
    @Select("SELECT * FROM studenttutoring.root WHERE rootname = #{username}")
    Root findRoot(@Param("username") String username);
}
