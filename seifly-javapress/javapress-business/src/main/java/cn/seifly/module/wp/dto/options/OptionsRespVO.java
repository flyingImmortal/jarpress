package cn.seifly.module.wp.dto.options;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - 设置参数 Response VO")
@Data
@ExcelIgnoreUnannotated
public class OptionsRespVO {

    @Schema(description = "参数id", requiredMode = Schema.RequiredMode.REQUIRED, example = "2106")
    @ExcelProperty("参数id")
    private Long optionId;

    @Schema(description = "参数名", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @ExcelProperty("参数名")
    private String optionName;

    @Schema(description = "参数值", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("参数值")
    private String optionValue;

    @Schema(description = "是否自动加载", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("是否自动加载")
    private String autoload;

}