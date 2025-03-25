package com.example.Project_MyBatis.service;

import com.example.Project_MyBatis.mapper.DepartmentMapper;
import com.example.Project_MyBatis.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    public Department getDepartmentById(int id) {
        return departmentMapper.getDepartmentById(id);
    }

    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartments();
    }
}
