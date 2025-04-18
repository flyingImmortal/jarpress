package cn.seifly.module.wp.dto.postmeta;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - 文章元数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class PostmetaRespVO {

    @Schema(description = "文章元数据id", requiredMode = Schema.RequiredMode.REQUIRED, example = "4065")
    @ExcelProperty("文章元数据id")
    private Long metaId;

    @Schema(description = "文章id", requiredMode = Schema.RequiredMode.REQUIRED, example = "13185")
    @ExcelProperty("文章id")
    private Long postId;

    @Schema(description = "键")
    @ExcelProperty("键")
    private String metaKey;

    @Schema(description = "值")
    @ExcelProperty("值")
    private String metaValue;

}