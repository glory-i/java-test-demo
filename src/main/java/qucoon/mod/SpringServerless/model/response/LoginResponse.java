
package qucoon.mod.SpringServerless.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import qucoon.mod.SpringServerless.model.entity.User;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String userEmail;
    private List<String> privileges = new ArrayList<>();
    private String token;
    private String responseCode;
    private String responseMessage;
    public User data;
}
