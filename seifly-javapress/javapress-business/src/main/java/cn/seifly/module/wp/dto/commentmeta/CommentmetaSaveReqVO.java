package cn.seifly.module.wp.dto.commentmeta;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - 评论元数据新增/修改 Request VO")
@Data
public class CommentmetaSaveReqVO {

    @Schema(description = "元数据id", requiredMode = Schema.RequiredMode.REQUIRED, example = "17767")
    private Long metaId;

    @Schema(description = "评论id", requiredMode = Schema.RequiredMode.REQUIRED, example = "17563")
    @NotNull(message = "评论id不能为空")
    private Long commentId;

    @Schema(description = "评论元数据键")
    private String metaKey;

    @Schema(description = "评论元数据值")
    private String metaValue;

}