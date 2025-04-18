package cn.seifly.module.wp.web.controller.h5qj.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SearchCategoryVO extends BaseVO {
    @Schema(description = "开始数", example = "0")
    private Integer offset;
    @Schema(description = "类型id", example = "0")
    private Long cat_id;
    @Schema(description = "搜索key", example = "0")
    private String search;
}
