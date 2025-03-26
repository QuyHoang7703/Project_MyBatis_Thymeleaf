CREATE DATABASE database_mybatis_v2;
USE database_mybatis_v2;
CREATE TABLE department (
    deptId INT AUTO_INCREMENT PRIMARY KEY,
    deptNM VARCHAR(255) NOT NULL
);

CREATE TABLE project (
     projectId VARCHAR(50) PRIMARY KEY,
     projectName VARCHAR(255) NOT NULL,
     difficulty VARCHAR(50),
     startDate DATE,
     updateDate DATE,
     deptId INT,
     FOREIGN KEY (deptId) REFERENCES department(deptId)
);

CREATE TABLE roles (
       roleId INT AUTO_INCREMENT PRIMARY KEY,
       roleName VARCHAR(30)

);

CREATE TABLE users (
       username VARCHAR(50) PRIMARY KEY,
       password VARCHAR(100) NOT NULL,
       roleId INT NOT NULL,

       CONSTRAINT FK_User_Role FOREIGN KEY(roleId) REFERENCES Roles(roleId)
);