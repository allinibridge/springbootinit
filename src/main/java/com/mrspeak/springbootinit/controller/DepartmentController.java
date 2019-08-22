package com.mrspeak.springbootinit.controller;

import com.mrspeak.springbootinit.bean.Department;
import com.mrspeak.springbootinit.dao.DepartmentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author allinibridge
 * @description 部门控制层
 * @date 2019/8/21
 */
@RestController
public class DepartmentController {

    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/dep/{id}")
    public Department getDep(@PathVariable Integer id){
        Department department = departmentMapper.getDepartment(id);
        return department;
    }
}
