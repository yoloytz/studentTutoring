package com.tutoring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author 云天泽 Steven
 * @version 1.0
 * Date: 2024-07-05
 * QQ：2311170320
 * 功能实现: 课程实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Classes {
    private int classId;
    private String className;
    private String classInfo;
    private String classMode;
    private String state;
    private int classTeacherId;
    private int classStudentId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime classTime;
    private String classPlace;
}
