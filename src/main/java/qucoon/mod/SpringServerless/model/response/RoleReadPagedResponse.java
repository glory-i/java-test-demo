package qucoon.mod.SpringServerless.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.dto.RoleDto;
import java.util.List;

@Data
@AllArgsConstructor
public class RoleReadPagedResponse {
    private String responseCode;
    private String responseMessage;
    private List<RoleDto> data;
    private long totalRecords;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
}
