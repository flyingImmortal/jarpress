package cn.seifly.module.wp.dto.termtaxonomy;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - 团队分类 Response VO")
@Data
@ExcelIgnoreUnannotated
public class TermTaxonomyRespVO {

    @Schema(description = "分类id", requiredMode = Schema.RequiredMode.REQUIRED, example = "4056")
    @ExcelProperty("分类id")
    private Long termTaxonomyId;

    @Schema(description = "团队id", requiredMode = Schema.RequiredMode.REQUIRED, example = "22032")
    @ExcelProperty("团队id")
    private Long termId;

    @Schema(description = "分类名", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("分类名")
    private String taxonomy;

    @Schema(description = "描述", requiredMode = Schema.RequiredMode.REQUIRED, example = "随便")
    @ExcelProperty("描述")
    private String description;

    @Schema(description = "分类父id", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("分类父id")
    private Long parent;

    @Schema(description = "总数", requiredMode = Schema.RequiredMode.REQUIRED, example = "23003")
    @ExcelProperty("总数")
    private Long count;

}