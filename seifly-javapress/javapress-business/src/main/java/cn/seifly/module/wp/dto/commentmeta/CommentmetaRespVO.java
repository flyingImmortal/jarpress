package cn.seifly.module.wp.dto.commentmeta;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - 评论元数据 Response VO")
@Data
@ExcelIgnoreUnannotated
public class CommentmetaRespVO {

    @Schema(description = "元数据id", requiredMode = Schema.RequiredMode.REQUIRED, example = "17767")
    @ExcelProperty("元数据id")
    private Long metaId;

    @Schema(description = "评论id", requiredMode = Schema.RequiredMode.REQUIRED, example = "17563")
    @ExcelProperty("评论id")
    private Long commentId;

    @Schema(description = "评论元数据键")
    @ExcelProperty("评论元数据键")
    private String metaKey;

    @Schema(description = "评论元数据值")
    @ExcelProperty("评论元数据值")
    private String metaValue;

}