package cn.seifly.module.wp.dto.termtaxonomy;


import cn.seifly.common.core.page.PageParam;
import cn.seifly.common.core.page.PageResult;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Schema(description = "管理后台 - 团队分类分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)

public class TermTaxonomyPageReqVO extends PageParam {

    @Schema(description = "团队id", example = "22032")
    private Long termId;

    @Schema(description = "分类名")
    private String taxonomy;

    @Schema(description = "描述", example = "随便")
    private String description;

    @Schema(description = "分类父id")
    private Long parent;

    @Schema(description = "总数", example = "23003")
    private Long count;

    @Schema(description = "id列表")
    private List<Long> idList;

}