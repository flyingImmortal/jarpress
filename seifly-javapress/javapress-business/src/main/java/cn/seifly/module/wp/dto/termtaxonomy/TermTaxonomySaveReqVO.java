package cn.seifly.module.wp.dto.termtaxonomy;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - 团队分类新增/修改 Request VO")
@Data
public class TermTaxonomySaveReqVO {

    @Schema(description = "分类id", requiredMode = Schema.RequiredMode.REQUIRED, example = "4056")
    private Long termTaxonomyId;

    @Schema(description = "团队id", requiredMode = Schema.RequiredMode.REQUIRED, example = "22032")
    @NotNull(message = "团队id不能为空")
    private Long termId;

    @Schema(description = "分类名", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "分类名不能为空")
    private String taxonomy;

    @Schema(description = "描述", requiredMode = Schema.RequiredMode.REQUIRED, example = "随便")
    @NotEmpty(message = "描述不能为空")
    private String description;

    @Schema(description = "分类父id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "分类父id不能为空")
    private Long parent;

    @Schema(description = "总数", requiredMode = Schema.RequiredMode.REQUIRED, example = "23003")
    @NotNull(message = "总数不能为空")
    private Long count;

}