package cn.seifly.module.wp.dto.termrelationships;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - 团队分类关系新增/修改 Request VO")
@Data
public class TermRelationshipsSaveReqVO {

    @Schema(description = "团队id", requiredMode = Schema.RequiredMode.REQUIRED, example = "27823")
    private Long objectId;

    @Schema(description = "分类id", requiredMode = Schema.RequiredMode.REQUIRED, example = "21903")
    private Long termTaxonomyId;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "排序不能为空")
    private Integer termOrder;

}