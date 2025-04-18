package cn.seifly.module.wp.web.controller.h5qj.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CommentVO extends BaseVO{
    @Schema(description = "帖子id", example = "0")
    private Long post_id;
    @Schema(description = "父帖子id", example = "0")
    private Long parent_id;
    @Schema(description = "评论内容", example = "123")
    private String content;
}
