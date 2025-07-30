package qucoon.mod.SpringServerless.model.entity;


import lombok.Data;
import qucoon.mod.SpringServerless.repository.annotation.Column;
import qucoon.mod.SpringServerless.repository.annotation.Table;
import qucoon.mod.SpringServerless.utility.constant.PrefixConstant;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDateTime;


@Data
@Table
public class Role  {
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  roleId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  roleName;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  roleDescription;
@Column(type="VARCHAR(n)",defaultValue="YES'",nullable=true , length=255)
public String  roleIsPublic;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  roleStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  roleCreatedAt;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  roleUpdatedAt;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  rolePrivilegeId;
@Column(type="int",nullable=true )
public int  rolePrivilegeRoleId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  rolePrivilegePrivilegeCode;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  rolePrivilegeStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  rolePrivilegeCreatedAt;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  rolePrivilegeUpdatedAt;
}
