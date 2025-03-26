package com.example.Project_MyBatis.mapper;

import com.example.Project_MyBatis.model.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectMapper {
    @Insert("INSERT INTO project (projectId, projectName, difficulty, startDate, updateDate, deptId) " +
            "VALUES (#{projectId}, #{projectName}, #{difficulty}, #{startDate}, #{updateDate}, #{department.deptId})")
    void insertProject(Project project);

    @Select("""
            SELECT p.*, d.deptId, d.deptNM FROM Project p
            JOIN department d ON p.deptId = d.deptId
            """)
    @Results({
            @Result(property = "department.deptId", column = "deptId"),
            @Result(property = "department.deptNM", column = "deptNm")
    })
    List<Project> getAllProject();
//    @Select("""
//            SELECT p.*, d.dept_id AS department_deptId, d.dept_nm AS department_deptNM
//            FROM project p
//            JOIN department d ON p.dept_id = d.dept_id
//            """)
//    @Results({
//            @Result(property = "projectId", column = "project_id"),
//            @Result(property = "projectName", column = "project_name"),
//            @Result(property = "difficulty", column = "difficulty"),
//            @Result(property = "startDate", column = "start_date"),
//            @Result(property = "updateDate", column = "update_date"),
//            @Result(property = "department.deptId", column = "department_deptId"),
//            @Result(property = "department.deptNM", column = "department_deptNM")
//    })
//    List<Project> getAllProjectsWithDepartment();
}
