
package qucoon.mod.SpringServerless.model.response;

import lombok.AllArgsConstructor;
import qucoon.mod.SpringServerless.model.entity.Module;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.*;

@Data
@AllArgsConstructor
public class ModuleReadSingleResponse {
    public String responseCode;
    public String responseMessage;
    public Module data;
}
