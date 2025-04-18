package cn.seifly.module.wp.dto.postmeta;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - 文章元数据新增/修改 Request VO")
@Data
public class PostmetaSaveReqVO {

    @Schema(description = "文章元数据id", requiredMode = Schema.RequiredMode.REQUIRED, example = "4065")
    private Long metaId;

    @Schema(description = "文章id", requiredMode = Schema.RequiredMode.REQUIRED, example = "13185")
    @NotNull(message = "文章id不能为空")
    private Long postId;

    @Schema(description = "键")
    private String metaKey;

    @Schema(description = "值")
    private String metaValue;

}