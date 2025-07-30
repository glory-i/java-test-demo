package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
@Data
public class ChangePasswordRequest {
    @NotEmpty(message = "userEmail is required")
    private String userEmail;


    @NotEmpty(message = "userPassword is required")
    private String userPassword;

    @NotEmpty(message = "oldPassword is required")
    private String oldPassword;
}
