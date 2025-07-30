package qucoon.mod.SpringServerless.utility;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.sql2o.Sql2o;
import qucoon.mod.SpringServerless.model.response.LoginResponse;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component(value = "myEnviroment")
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Environment {

    @Autowired
    public org.springframework.core.env.Environment properties;

    @Autowired
    private DatabaseUtil databaseUtil; // Inject DatabaseUtil here

    public String applicationName = "QucoonServerless";
    public String ipAddress;
    public String maker;
    public String client;
    public String authorizationHeader;
    public boolean authorizationRequired = true;
    public String stage;
    public String smtpFromEmail;
    public String smtpFromName;
    public String smtpApiKey;
    public String applicationPath;
    public List<String> awsSecretName;
    public String mid;
    //public Object userInfo;
    public LoginResponse userInfo;

    public JwtUtility jwtUtil = new JwtUtility();



    public boolean isDatasource = false;
    public boolean executeDatabaseMigration = false;

    @Value("${datasource.url}")
    private String databaseUrl;

    @Value("${datasource.username}")
    private String databaseUsername;

    @Value("${datasource.password}")
    private String databasePassword;

   // @PostConstruct
    public void initialize() {

        if (databaseUrl == null || databaseUsername == null || databasePassword == null) {
            throw new IllegalStateException("Database properties are not set!");
        }

        // Ensure DatabaseUtil is initialized
        if (databaseUtil == null) {
            throw new IllegalStateException("DatabaseUtil is not initialized!");
        }
    }

    public DatabaseUtil getDatabaseUtil() {
        return databaseUtil;
    }
}