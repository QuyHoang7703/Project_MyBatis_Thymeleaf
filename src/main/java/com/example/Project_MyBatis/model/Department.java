package com.example.Project_MyBatis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class Department {
    private int deptId;
    private String deptNM;
    private List<Project> projects;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptNM() {
        return deptNM;
    }

    public void setDeptNM(String deptNM) {
        this.deptNM = deptNM;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
