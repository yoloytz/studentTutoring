package com.tutoring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 云天泽 Steven
 * @version 1.0
 * Date: 2024-07-05
 * QQ：2311170320
 * 功能实现: 管理员实体类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Root {
    private int rootId;
    private String rootName;
    private String rootPassword;
    private String info;
}
