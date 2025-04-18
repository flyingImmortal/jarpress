package cn.seifly.module.wp.dto.options;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Schema(description = "管理后台 - 设置参数新增/修改 Request VO")
@Data
public class OptionsSaveReqVO {

    @Schema(description = "参数id", requiredMode = Schema.RequiredMode.REQUIRED, example = "2106")
    private Long optionId;

    @Schema(description = "参数名", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @NotEmpty(message = "参数名不能为空")
    private String optionName;

    @Schema(description = "参数值", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "参数值不能为空")
    private String optionValue;

    @Schema(description = "是否自动加载", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "是否自动加载不能为空")
    private String autoload;

}