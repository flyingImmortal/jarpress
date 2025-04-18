package cn.seifly.module.wp.dto.terms;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - 分类新增/修改 Request VO")
@Data
public class TermsSaveReqVO {

    @Schema(description = "团队id", requiredMode = Schema.RequiredMode.REQUIRED, example = "31158")
    private Long termId;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @NotEmpty(message = "名称不能为空")
    private String name;

    @Schema(description = "URL别名", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "URL别名不能为空")
    private String slug;

    @Schema(description = "分类id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "分类id不能为空")
    private Long termGroup;

}