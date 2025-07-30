package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class CompleteEnrollmentRequest {
    @NotEmpty(message = "userEmail is required")
    private String userEmail;

    @NotEmpty(message = "otp is required")
    private String otp;
}
