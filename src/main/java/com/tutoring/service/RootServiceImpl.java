package com.tutoring.service;

import com.tutoring.mapper.RootMapper;
import com.tutoring.pojo.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public Root logRoot(String rootName, String rootPassword) {
        Root root = rootMapper.findRoot(rootName);
        if(root != null && root.getRootPassword().equals(rootPassword)){
            return root;
        }else {
            return null;
        }
    }
}
