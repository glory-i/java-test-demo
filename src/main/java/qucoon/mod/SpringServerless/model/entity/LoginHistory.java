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
public class LoginHistory  {
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  loginHistoryId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  loginHistoryUsername;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  loginHistoryIpAddress;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  loginHistoryDeviceId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  loginHistoryLongitude;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  loginHistoryLatitude;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  loginHistoryStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  loginHistoryCreatedAt;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  loginHistoryUpdatedAt;
}
