

CREATE TABLE _USER
(
    userId INT PRIMARY KEY AUTO_INCREMENT ,
    userStatus varchar(50) DEFAULT 'PENDING',
    userCreatedAt datetime DEFAULT getdate(),
    userUpdatedAt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT getdate(),
    userId   UNIQUE,
    userRoleId  ,
    userEmail  ,
    userFirstName  ,
    userLastName  ,
    userPassword  ,
    userPhoneNumber  ,
    userJobRoleAlias  ,
    userStatus  ,
    userCreatedAt   ,
    userUpdatedAt  ,
    userLoginCount ,
    userLastLoginDate ,
    userLastLoginIpAddress 
CREATE TABLE _COURSE
(
    courseId INT PRIMARY KEY AUTO_INCREMENT ,
    courseStatus varchar(50) DEFAULT 'PENDING',
    courseCreatedAt datetime DEFAULT getdate(),
    courseUpdatedAt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT getdate(),
    courseUserId ,
    courseName ,
    courseDescription ,
    courseStatus  ,
    courseCreatedAt   ,
    courseUpdatedAt  
CREATE TABLE _USER
(
    userId INT PRIMARY KEY AUTO_INCREMENT ,
    userStatus varchar(50) DEFAULT 'PENDING',
    userCreatedAt datetime DEFAULT getdate(),
    userUpdatedAt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT getdate(),
    userId   UNIQUE,
    userRoleId  ,
    userEmail  ,
    userFirstName  ,
    userLastName  ,
    userPassword  ,
    userPhoneNumber  ,
    userJobRoleAlias  ,
    userStatus  ,
    userCreatedAt   ,
    userUpdatedAt  ,
    userLoginCount ,
    userLastLoginDate ,
    userLastLoginIpAddress 
CREATE TABLE _USER_OTP
(
    userOtpId INT PRIMARY KEY AUTO_INCREMENT ,
    userOtpStatus varchar(50) DEFAULT 'PENDING',
    userOtpCreatedAt datetime DEFAULT getdate(),
    userOtpUpdatedAt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT getdate(),
    userOtpUsername ,
    userOtpOtp 
CREATE TABLE _LOGIN_HISTORY
(
    loginHistoryId INT PRIMARY KEY AUTO_INCREMENT ,
    loginHistoryStatus varchar(50) DEFAULT 'PENDING',
    loginHistoryCreatedAt datetime DEFAULT getdate(),
    loginHistoryUpdatedAt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT getdate(),
    loginHistoryUsername ,
    loginHistoryIpAddress ,
    loginHistoryDeviceId ,
    loginHistoryLongitude ,
    loginHistoryLatitude 
CREATE TABLE _PRIVILEGE
(
    privilegeId INT PRIMARY KEY AUTO_INCREMENT ,
    privilegeStatus varchar(50) DEFAULT 'PENDING',
    privilegeCreatedAt datetime DEFAULT getdate(),
    privilegeUpdatedAt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT getdate(),
    privilegeCode ,
    privilegeName ,
    privilegeModuleName ,
    privilegeDescription 
CREATE TABLE _ROLE
(
    roleId INT PRIMARY KEY AUTO_INCREMENT ,
    roleStatus varchar(50) DEFAULT 'PENDING',
    roleCreatedAt datetime DEFAULT getdate(),
    roleUpdatedAt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT getdate(),
    roleName ,
    roleDescription ,
    roleIsPublic ,
    rolePrivilegeId  UNIQUE,
    rolePrivilegeRoleId ,
    rolePrivilegePrivilegeCode ,
    rolePrivilegeStatus ,
    rolePrivilegeCreatedAt ,
    rolePrivilegeUpdatedAt 
CREATE TABLE _MODULE
(
    moduleId INT PRIMARY KEY AUTO_INCREMENT ,
    moduleStatus varchar(50) DEFAULT 'PENDING',
    moduleCreatedAt datetime DEFAULT getdate(),
    moduleUpdatedAt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT getdate(),
    moduleName ,
    moduleDescription 
CREATE TABLE _CHECKER_QUEUE
(
    checkerQueueId INT PRIMARY KEY AUTO_INCREMENT ,
    checkerQueueStatus varchar(50) DEFAULT 'PENDING',
    checkerQueueCreatedAt datetime DEFAULT getdate(),
    checkerQueueUpdatedAt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT getdate(),
    checkerQueueMakerId ,
    checkerQueueCheckerId ,
    checkerQueueModule ,
    checkerQueueAction ,
    checkerQueueRequest ,
    checkerQueueReason 
CREATE TABLE _AUDIT_LOG
(
    auditLogId INT PRIMARY KEY AUTO_INCREMENT ,
    auditLogStatus varchar(50) DEFAULT 'PENDING',
    auditLogCreatedAt datetime DEFAULT getdate(),
    auditLogUpdatedAt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT getdate(),
    auditLogUserId ,
    auditLogAction ,
    auditLogRequest ,
    auditLogResponse ,
    auditLogModule ,
    auditLogResponseCode ,
    auditLogResponseMessage 
CREATE TABLE _ROLE_PRIVILEGE
(
    rolePrivilegeId INT PRIMARY KEY AUTO_INCREMENT ,
    rolePrivilegeStatus varchar(50) DEFAULT 'PENDING',
    rolePrivilegeCreatedAt datetime DEFAULT getdate(),
    rolePrivilegeUpdatedAt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT getdate(),
    rolePrivilegeRoleId ,
    rolePrivilegePrivilegeCode 
