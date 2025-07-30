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
public class User  {
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  userId ;
@Column(type="int", foreignKey=true,reference="USER()")
public int  userRoleId ;
@Column(type="VARCHAR(n)", foreignKey=true,reference="USER()")
public String  userEmail ;
@Column(type="VARCHAR(n)", foreignKey=true,reference="USER()")
public String  userFirstName ;
@Column(type="VARCHAR(n)", foreignKey=true,reference="USER()")
public String  userLastName ;
@Column(type="VARCHAR(n)", foreignKey=true,reference="USER()")
public String  userPassword ;
@Column(type="VARCHAR(n)", foreignKey=true,reference="USER()")
public String  userPhoneNumber ;
@Column(type="VARCHAR(n)", foreignKey=true,reference="USER()")
public String  userJobRoleAlias ;
@Column(type="VARCHAR(n)", foreignKey=true,reference="USER()")
public String  userStatus ;
@Column(type="DateTime", foreignKey=true,reference="USER()")
public String  userCreatedAt  ;
@Column(type="DateTime", foreignKey=true,reference="USER()")
public String  userUpdatedAt ;
@Column(type="int",defaultValue="0",nullable=true )
public int  userLoginCount;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  userLastLoginDate;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  userLastLoginIpAddress;
}
