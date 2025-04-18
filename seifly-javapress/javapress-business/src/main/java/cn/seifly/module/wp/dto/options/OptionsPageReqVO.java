package cn.seifly.module.wp.dto.options;


import cn.seifly.common.core.page.PageParam;
import cn.seifly.common.core.page.PageResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 设置参数分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)

public class OptionsPageReqVO extends PageParam {

    @Schema(description = "参数名", example = "李四")
    private String optionName;

    @Schema(description = "参数值")
    private String optionValue;

    @Schema(description = "是否自动加载")
    private String autoload;

}