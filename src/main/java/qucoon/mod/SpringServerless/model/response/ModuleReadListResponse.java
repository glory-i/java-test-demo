package qucoon.mod.SpringServerless.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.model.entity.Module;
import java.util.List;

@Data
@AllArgsConstructor
public class ModuleReadListResponse  {

public String responseCode;
public String responseMessage;
public List<Module> data;
}
