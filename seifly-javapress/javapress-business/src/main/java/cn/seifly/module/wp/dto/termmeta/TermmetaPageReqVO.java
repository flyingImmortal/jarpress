package cn.seifly.module.wp.dto.termmeta;


import cn.seifly.common.core.page.PageParam;
import cn.seifly.common.core.page.PageResult;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 团队元数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)

public class TermmetaPageReqVO extends PageParam {

    @Schema(description = "团队id", example = "13442")
    private Long termId;

    @Schema(description = "键")
    private String metaKey;

    @Schema(description = "值")
    private String metaValue;

}