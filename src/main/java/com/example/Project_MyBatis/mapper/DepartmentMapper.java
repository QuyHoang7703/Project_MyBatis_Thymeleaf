package com.example.Project_MyBatis.mapper;

import com.example.Project_MyBatis.model.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    @Select("SELECT * FROM Department WHERE deptId = #{deptId}")
    Department getDepartmentById(int deptId);

    @Select("SELECT * FROM Department")
    List<Department> getAllDepartments();
}
