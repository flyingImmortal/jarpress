package cn.seifly.module.wp.dto.usermeta;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - 用户元数据新增/修改 Request VO")
@Data
public class UsermetaSaveReqVO {

    @Schema(description = "用户元数据", requiredMode = Schema.RequiredMode.REQUIRED, example = "31361")
    private Long umetaId;

    @Schema(description = "用户id", requiredMode = Schema.RequiredMode.REQUIRED, example = "740")
    @NotNull(message = "用户id不能为空")
    private Long userId;

    @Schema(description = "键")
    private String metaKey;

    @Schema(description = "值")
    private String metaValue;

}