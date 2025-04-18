package cn.seifly.module.wp.dto.termmeta;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - 团队元数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class TermmetaRespVO {

    @Schema(description = "团队元数据id", requiredMode = Schema.RequiredMode.REQUIRED, example = "28543")
    @ExcelProperty("团队元数据id")
    private Long metaId;

    @Schema(description = "团队id", requiredMode = Schema.RequiredMode.REQUIRED, example = "13442")
    @ExcelProperty("团队id")
    private Long termId;

    @Schema(description = "键")
    @ExcelProperty("键")
    private String metaKey;

    @Schema(description = "值")
    @ExcelProperty("值")
    private String metaValue;

}