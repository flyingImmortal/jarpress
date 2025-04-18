package cn.seifly.module.wp.dto.termrelationships;


import cn.seifly.common.core.page.PageParam;
import cn.seifly.common.core.page.PageResult;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 团队分类关系分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)

public class TermRelationshipsPageReqVO extends PageParam {

    @Schema(description = "排序")
    private Integer termOrder;

    @Schema(description = "帖子id")
    private Long objectId;

    @Schema(description = "分类id")
    private Long termTaxonomyId;
}