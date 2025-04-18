package cn.seifly.module.wp.web.controller.h5qj.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Schema(description = "帖子请求参数")
@Data
public class PostVO extends BaseVO {
    @Schema(description = "开始数", example = "0")
    private Integer offset;
    @Schema(description = "排序名称", example = "0")
    private String sort;
    @Schema(description = "帖子id", example = "0")
    private Long post_id;
    @Schema(description = "页面id", example = "0")
    private Long page_id;
    @Schema(description = "查询类型", example = "0")
    private String track;
}
