package com.example.Project_MyBatis.service;

import com.example.Project_MyBatis.dto.AddProjectResponse;
import com.example.Project_MyBatis.dto.ProjectRequestDTO;
import com.example.Project_MyBatis.dto.ProjectResponseDTO;
import com.example.Project_MyBatis.mapper.DepartmentMapper;
import com.example.Project_MyBatis.mapper.ProjectMapper;
import com.example.Project_MyBatis.model.Department;
import com.example.Project_MyBatis.model.Project;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j
public class ProjectService {
    private final ProjectMapper projectMapper;
    private final DepartmentMapper departmentMapper;


    public ProjectService(ProjectMapper projectMapper, DepartmentMapper departmentMapper) {
        this.projectMapper = projectMapper;
        this.departmentMapper = departmentMapper;
    }

    public AddProjectResponse createProject(ProjectRequestDTO projectRequestDTO) {
        Project project = new Project();
        project.setProjectName(projectRequestDTO.getProjectName());
        project.setDifficulty(projectRequestDTO.getDifficulty());
        project.setStartDate(LocalDate.now());

        Department department = this.departmentMapper.getDepartmentById(projectRequestDTO.getDeptId());
        project.setDepartment(department);

        int savedProjectId = this.projectMapper.insertProject(project);
        AddProjectResponse addProjectResponse = new AddProjectResponse();
        addProjectResponse.setProjectId(savedProjectId);
        addProjectResponse.setProjectNM(projectRequestDTO.getProjectName());

        System.out.println(">>>>>>>>>>>>>> " + savedProjectId);
        return addProjectResponse;
    }

    public List<ProjectResponseDTO> getAllProjects() {
        List<Project> projects = this.projectMapper.getAllProject();
        List<ProjectResponseDTO> projectResponseDTOs = projects.stream().map(this::convertToProjectResponseDTO).toList();

        return projectResponseDTOs;
    }

    public ProjectResponseDTO getProjectById(int projectId) {
        Project project = this.projectMapper.findById(projectId);
        return convertToProjectResponseDTO(project);
    }

    public ProjectResponseDTO convertToProjectResponseDTO(Project project) {
        ProjectResponseDTO projectResponseDTO = new ProjectResponseDTO();
        projectResponseDTO.setProjectId(project.getProjectId());
        projectResponseDTO.setProjectName(project.getProjectName());
        projectResponseDTO.setDifficulty(project.getDifficulty());
        projectResponseDTO.setStartDate(project.getStartDate());
        projectResponseDTO.setUpdateDate(project.getUpdateDate());
        projectResponseDTO.setDeptNM(project.getDepartment().getDeptNM());

        return projectResponseDTO;
    }

    public boolean isAvailableProjectName(String projectName, int projectId) {
        int count = this.projectMapper.countByProjectName(projectName, projectId);
        return count != 0;
    }

    public void updateProject(ProjectRequestDTO projectRequestDTO) {
        Project project = this.projectMapper.findById(projectRequestDTO.getProjectId());
        project.setProjectName(projectRequestDTO.getProjectName());
        project.setDifficulty(projectRequestDTO.getDifficulty());
        project.setUpdateDate(LocalDate.now());
        Department department = this.departmentMapper.getDepartmentById(projectRequestDTO.getDeptId());
        project.setDepartment(department);

        this.projectMapper.updateProject(project);
    }
}
