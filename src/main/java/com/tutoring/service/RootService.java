package com.tutoring.service;

import com.tutoring.pojo.Classes;
import com.tutoring.pojo.Root;

import java.util.List;

/**
 * @author 云天泽 Steven
 * @version 1.0
 * Date: 2024-07-05
 * QQ：2311170320
 * 功能实现: 管理员Service层，调用和数据库连接的Mapper
 */
public interface RootService {
    /**
     * 验证管理员输入的用户名与密码
     * @param rootName 从前端得到的用户输入的用户名
     * @param rootPassword 从网页得到的用户输入的密码
     * @return Root 返回用户信息对象
     */
    Root logRoot(String rootName,String rootPassword);

    /**
     * @return 返回没有审核的课程
     */
    List<Classes> getAllClassesNoVet();

    /**
     * 审核通过课程
     * @param id 审核通过的课程id
     */
    void vetClass(int id);


    /**
     * 删除课程
     * @param id 不通过的课程id
     */
    void deleteClass(int id);
}
