package qucoon.mod.SpringServerless.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.lang.Nullable;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.sql.DataSource;

@Component
public class DatabaseUtil {

    @Value("${datasource.url}")
    private String dbUrl;

    @Value("${datasource.username}")
    private String dbUsername;

    @Value("${datasource.password}")
    private String dbPassword;

    @Value("${app.is.datasource:false}")
    private boolean isDatasource;

    private Sql2o sql2o;

    @PostConstruct
    public void init() {
        System.out.println("Initializing DatabaseUtil...");
        System.out.println("dbUrl: " + dbUrl);
        //System.out.println("dbUsername: " + dbUsername);
        //System.out.println("dbPassword: " + dbPassword);

        if (dbUrl == null || dbUsername == null || dbPassword == null) {
            throw new IllegalStateException("Database properties are not set!");
        }

        this.sql2o = new Sql2o(dbUrl, dbUsername, dbPassword);
    }

    @Nullable
    public Connection getSql2oConnection() {
        return sql2o.open();
    }

    public Sql2o getSql2o() {
        return sql2o;
    }
}