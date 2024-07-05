package com.tutoring.service;

import com.tutoring.pojo.Root;

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
}
