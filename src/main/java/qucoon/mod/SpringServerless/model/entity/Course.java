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
public class Course  {
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  courseId;
@Column(type="int", foreignKey=true,reference="COURSE()")
public int  courseUserId;
@Column(type="VARCHAR(n)", foreignKey=true,reference="COURSE()")
public String  courseName;
@Column(type="VARCHAR(n)", foreignKey=true,reference="COURSE()")
public String  courseDescription;
@Column(type="VARCHAR(n)", foreignKey=true,reference="COURSE()")
public String  courseStatus ;
@Column(type="DateTime", foreignKey=true,reference="COURSE()")
public String  courseCreatedAt  ;
@Column(type="DateTime", foreignKey=true,reference="COURSE()")
public String  courseUpdatedAt ;
}
