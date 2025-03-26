package com.example.Project_MyBatis;

import com.example.Project_MyBatis.mapper.ProjectMapper;
import com.example.Project_MyBatis.model.Department;
import com.example.Project_MyBatis.model.Project;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("1234567"));

    }
}
