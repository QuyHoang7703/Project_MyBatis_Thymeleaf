package com.example.Project_MyBatis.mapper;

import com.example.Project_MyBatis.model.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectMapper {
    @Insert("INSERT INTO project (projectName, difficulty, startDate, updateDate, deptId) " +
            "VALUES (#{projectName}, #{difficulty}, #{startDate}, #{updateDate}, #{department.deptId})")
//    @Select("SELECT * FROM project WHERE projectId = #{projectId}") // Lấy lại Project vừa thêm
    @Options(useGeneratedKeys = true, keyProperty = "projectId", keyColumn = "projectId")
//    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "projectId", before = false, resultType = int.class)
    int insertProject(Project project);


    @Select("""
            SELECT p.*, d.deptId, d.deptNM FROM Project p
            JOIN department d ON p.deptId = d.deptId
            """)
    @Results({
            @Result(property = "department.deptId", column = "deptId"),
            @Result(property = "department.deptNM", column = "deptNm")
    })
    List<Project> getAllProject();

    @Select("SELECT * FROM Project p " +
            "WHERE p.projectId = #{projectId} ")
    @Results({
            @Result(property = "department.deptId", column="deptId")
    })
    Project findById(@Param("projectId") int projectId);

    @Select("SELECT COUNT(*) FROM project p " +
            "WHERE p.projectName = #{projectNM} " +
            "AND p.projectId != #{projectId}")
    int countByProjectName(@Param("projectNM") String projectNM, @Param("projectId") int projectId);

    @Update("UPDATE project SET projectName = #{projectName}, difficulty = #{difficulty}, updateDate = #{updateDate}, deptId = #{department.deptId} " +
            "WHERE projectId = #{projectId} ")
    void updateProject(Project project);

}


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