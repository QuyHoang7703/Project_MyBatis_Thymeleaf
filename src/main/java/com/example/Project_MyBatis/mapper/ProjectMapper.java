package com.example.Project_MyBatis.mapper;

import com.example.Project_MyBatis.model.Project;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectMapper {
    @Insert("INSERT INTO project (projectId, projectName, difficulty, startDate, updateDate, deptId) " +
            "VALUES (#{projectId}, #{projectName}, #{difficulty}, #{startDate}, #{updateDate}, #{department.deptId})")
    void insertProject(Project project);
}
