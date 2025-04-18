package cn.seifly.module.wp.dto.commentmeta;


import cn.seifly.common.core.page.PageParam;
import cn.seifly.common.core.page.PageResult;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 评论元数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)

public class CommentmetaPageReqVO extends PageParam {

    @Schema(description = "评论id", example = "17563")
    private Long commentId;

    @Schema(description = "评论元数据键")
    private String metaKey;

    @Schema(description = "评论元数据值")
    private String metaValue;

}