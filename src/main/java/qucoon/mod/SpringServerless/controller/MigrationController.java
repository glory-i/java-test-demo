
 
package qucoon.mod.SpringServerless.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import java.io.IOException;
import org.springframework.util.StreamUtils;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import qucoon.mod.SpringServerless.utility.model.response.BaseDataResponse;

import java.nio.charset.StandardCharsets;


@RestController
@RequestMapping("/migration")
@Validated
public class MigrationController {

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/execute")
    public BaseDataResponse execute(@PathVariable String stage) {
        Resource resource = resourceLoader.getResource("classpath:MSSQL_DATABASE.sql");
        String sqlScript = "";

        try {
            // Read the content of the SQL file into a String
            sqlScript = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            sqlScript = "No Database Migration Script";
        }
        return new BaseDataResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                sqlScript
            );

    }
    //


}
//