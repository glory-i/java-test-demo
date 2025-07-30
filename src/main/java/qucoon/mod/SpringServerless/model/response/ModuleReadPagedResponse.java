package qucoon.mod.SpringServerless.model.response;

import lombok.AllArgsConstructor;
import qucoon.mod.SpringServerless.model.entity.Module;
import lombok.Data;
import qucoon.mod.SpringServerless.model.dto.ModuleDto;
import java.util.List;

@Data
@AllArgsConstructor
public class ModuleReadPagedResponse {
    private String responseCode;
    private String responseMessage;
    private List<ModuleDto> data;
    private long totalRecords;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
}
