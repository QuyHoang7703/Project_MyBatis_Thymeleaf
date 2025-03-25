package com.example.Project_MyBatis.service;

import com.example.Project_MyBatis.dto.ProjectDTO;
import com.example.Project_MyBatis.mapper.DepartmentMapper;
import com.example.Project_MyBatis.mapper.ProjectMapper;
import com.example.Project_MyBatis.model.Department;
import com.example.Project_MyBatis.model.Project;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProjectService {
    private final ProjectMapper projectMapper;
    private final DepartmentMapper departmentMapper;


    public ProjectService(ProjectMapper projectMapper, DepartmentMapper departmentMapper) {
        this.projectMapper = projectMapper;
        this.departmentMapper = departmentMapper;
    }

    public void createProject(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setProjectId(projectDTO.getProjectId());
        project.setProjectName(projectDTO.getProjectName());
        project.setDifficulty(projectDTO.getDifficulty());
        project.setStartDate(LocalDate.now());

        Department department = this.departmentMapper.getDepartmentById(projectDTO.getDeptId());
        project.setDepartment(department);

        this.projectMapper.insertProject(project);
    }
}
