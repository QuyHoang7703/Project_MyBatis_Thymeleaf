package com.example.Project_MyBatis.controller;

import com.example.Project_MyBatis.dto.ProjectDTO;
import com.example.Project_MyBatis.model.Department;
import com.example.Project_MyBatis.model.Project;
import com.example.Project_MyBatis.service.DepartmentService;
import com.example.Project_MyBatis.service.ProjectService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("projects")
@Log4j
public class ProjectController {
    private final ProjectService projectService;
    private final DepartmentService departmentService;

    public ProjectController(ProjectService projectService, DepartmentService departmentService) {
        this.projectService = projectService;
        this.departmentService = departmentService;
    }

    @GetMapping
    public String showAddProjectForm(Model model) {
        System.out.println(">>>>>>>");
        model.addAttribute("projectDTO", new ProjectDTO());
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "projects/add-project";
    }

    @PostMapping("/add")
    public String addProject(@ModelAttribute("projectDTO") ProjectDTO projectDTO) {
        projectService.createProject(projectDTO);
        return "complete-form";
    }
}
