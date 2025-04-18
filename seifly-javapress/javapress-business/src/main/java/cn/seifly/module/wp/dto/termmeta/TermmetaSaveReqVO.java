package cn.seifly.module.wp.dto.termmeta;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - 团队元数据新增/修改 Request VO")
@Data
public class TermmetaSaveReqVO {

    @Schema(description = "团队元数据id", requiredMode = Schema.RequiredMode.REQUIRED, example = "28543")
    private Long metaId;

    @Schema(description = "团队id", requiredMode = Schema.RequiredMode.REQUIRED, example = "13442")
    @NotNull(message = "团队id不能为空")
    private Long termId;

    @Schema(description = "键")
    private String metaKey;

    @Schema(description = "值")
    private String metaValue;

}