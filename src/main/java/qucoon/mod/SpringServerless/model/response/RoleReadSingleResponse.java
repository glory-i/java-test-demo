
package qucoon.mod.SpringServerless.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.*;

@Data
@AllArgsConstructor
public class RoleReadSingleResponse {
    public String responseCode;
    public String responseMessage;
    public Role data;
}
