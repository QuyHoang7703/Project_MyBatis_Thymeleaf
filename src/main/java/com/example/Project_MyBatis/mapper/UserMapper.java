package com.example.Project_MyBatis.mapper;

import com.example.Project_MyBatis.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT u.* FROM users u " +
            "WHERE u.username = #{username}")
    @Results({
            @Result(property = "role.roleId", column = "roleId"),
            @Result(property = "role.roleName", column="roleName")
    })
    User findByUsername(String username);
}
