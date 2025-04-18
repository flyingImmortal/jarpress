package cn.seifly.module.wp.dto.usermeta;


import cn.seifly.common.core.page.PageParam;
import cn.seifly.common.core.page.PageResult;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 用户元数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)

public class UsermetaPageReqVO extends PageParam {

    @Schema(description = "用户id", example = "740")
    private Long userId;

    @Schema(description = "键")
    private String metaKey;

    @Schema(description = "值")
    private String metaValue;

}