package com.example.Project_MyBatis.controller;

import com.example.Project_MyBatis.dto.AddProjectResponse;
import com.example.Project_MyBatis.dto.ProjectRequestDTO;
import com.example.Project_MyBatis.dto.ProjectResponseDTO;
import com.example.Project_MyBatis.model.Department;
import com.example.Project_MyBatis.model.Project;
import com.example.Project_MyBatis.service.DepartmentService;
import com.example.Project_MyBatis.service.ProjectService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("projects")
public class ProjectController {
    private final ProjectService projectService;
    private final DepartmentService departmentService;

    public ProjectController(ProjectService projectService, DepartmentService departmentService) {
        this.projectService = projectService;
        this.departmentService = departmentService;
    }

    @GetMapping("/add-project-form")
    public String showAddProjectForm(Model model) {
        System.out.println(">>>>>>>");
        model.addAttribute("projectRequestDTO", new ProjectRequestDTO());
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "projects/add-project";
    }

    @PostMapping("/add")
    public String addProject(@ModelAttribute("projectDTO") ProjectRequestDTO projectRequestDTO,
                             Model model) {
        AddProjectResponse addProjectResponse = this.projectService.createProject(projectRequestDTO);
        model.addAttribute("addProjectResponse", addProjectResponse);
        return "complete-form";
    }

    @GetMapping()
    public String showAllProjects(Model model) {
        List<ProjectResponseDTO> projectResponseDTOS = projectService.getAllProjects();
        model.addAttribute("projectResponseDTOS", projectResponseDTOS);
        return "projects/project-list";
    }

    @GetMapping("detail/{projectId}")
    public String showProjectDetail(@PathVariable("projectId") int projectId,
                                    Model model) {
        ProjectResponseDTO projectResponseDTO = this.projectService.getProjectById(projectId);
        model.addAttribute("projectResponseDTO", projectResponseDTO);
        List<Department> departments = this.departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "projects/project-detail";
    }

    @PostMapping("update")
    public String updateProject(@ModelAttribute ProjectRequestDTO projectRequestDTO, Model model) {
        boolean isAvailableProjectName = this.projectService.isAvailableProjectName(projectRequestDTO.getProjectName(), projectRequestDTO.getProjectId());
        if(isAvailableProjectName) {
            model.addAttribute("projectResponseDTO", projectRequestDTO);
            model.addAttribute("errorMessage", "Project name already exists");
            List<Department> departments = this.departmentService.getAllDepartments();
            model.addAttribute("departments", departments);
            return "projects/project-detail";
        }

        this.projectService.updateProject(projectRequestDTO);
        return "redirect:/projects";
    }



}
