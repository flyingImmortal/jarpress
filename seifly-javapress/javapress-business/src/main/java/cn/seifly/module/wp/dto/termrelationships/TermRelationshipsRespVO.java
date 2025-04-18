package cn.seifly.module.wp.dto.termrelationships;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - 团队分类关系 Response VO")
@Data
@ExcelIgnoreUnannotated
public class TermRelationshipsRespVO {

    @Schema(description = "团队id", requiredMode = Schema.RequiredMode.REQUIRED, example = "27823")
    @ExcelProperty("团队id")
    private Long objectId;

    @Schema(description = "分类id", requiredMode = Schema.RequiredMode.REQUIRED, example = "21903")
    @ExcelProperty("分类id")
    private Long termTaxonomyId;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("排序")
    private Integer termOrder;

}