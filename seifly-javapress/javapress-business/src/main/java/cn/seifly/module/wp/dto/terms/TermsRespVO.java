package cn.seifly.module.wp.dto.terms;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - 分类 Response VO")
@Data
@ExcelIgnoreUnannotated
public class TermsRespVO {

    @Schema(description = "团队id", requiredMode = Schema.RequiredMode.REQUIRED, example = "31158")
    @ExcelProperty("团队id")
    private Long termId;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @ExcelProperty("名称")
    private String name;

    @Schema(description = "URL别名", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("URL别名")
    private String slug;

    @Schema(description = "分类id", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("分类id")
    private Long termGroup;

}