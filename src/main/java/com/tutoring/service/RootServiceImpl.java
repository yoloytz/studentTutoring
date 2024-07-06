package com.tutoring.service;

import com.tutoring.mapper.ClassesMapper;
import com.tutoring.mapper.RootMapper;
import com.tutoring.pojo.Classes;
import com.tutoring.pojo.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 云天泽 Steven
 * @version 1.0
 * Date: 2024-07-05
 * QQ：2311170320
 * 功能实现: 实现管理员服务接口
 */
@Service
public class RootServiceImpl implements RootService {
    @Autowired
    private RootMapper rootMapper;
    @Autowired
    private ClassesMapper classesMapper;
    @Override
    public Root logRoot(String rootName, String rootPassword) {
        Root root = rootMapper.findRoot(rootName);
        if(root != null && root.getRootPassword().equals(rootPassword)){
            return root;
        }else {
            return null;
        }
    }

    /**
     * @return 返回没有审核的课程
     */
    @Override
    public List<Classes> getAllClassesNoVet() {
        return classesMapper.getAllClassesNoVet();
    }

    /**
     * 审核课程
     * @param id 审核通过的课程id
     */
    @Override
    public void vetClass(int id) {
        classesMapper.passTheCourse(id);
    }

    /**
     * 删除课程
     *
     * @param id 不通过的课程id
     */
    @Override
    public void deleteClass(int id) {
        classesMapper.deleteTheCourse(id);
    }
}
