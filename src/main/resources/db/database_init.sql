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