package cn.seifly.module.wp.dto.usermeta;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - 用户元数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class UsermetaRespVO {

    @Schema(description = "用户元数据", requiredMode = Schema.RequiredMode.REQUIRED, example = "31361")
    @ExcelProperty("用户元数据")
    private Long umetaId;

    @Schema(description = "用户id", requiredMode = Schema.RequiredMode.REQUIRED, example = "740")
    @ExcelProperty("用户id")
    private Long userId;

    @Schema(description = "键")
    @ExcelProperty("键")
    private String metaKey;

    @Schema(description = "值")
    @ExcelProperty("值")
    private String metaValue;

}