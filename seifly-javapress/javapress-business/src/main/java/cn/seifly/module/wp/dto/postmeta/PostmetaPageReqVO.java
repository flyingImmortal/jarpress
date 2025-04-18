package cn.seifly.module.wp.dto.postmeta;


import cn.seifly.common.core.page.PageParam;
import cn.seifly.common.core.page.PageResult;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Schema(description = "管理后台 - 文章元数据分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)

public class PostmetaPageReqVO extends PageParam {

    @Schema(description = "文章id", example = "13185")
    private Long postId;

    @Schema(description = "键")
    private String metaKey;

    @Schema(description = "值")
    private String metaValue;
    @Schema(description = "id列表")
    private List<Long> postIdList;

    @Schema(description = "键")
    private List<String> metaKeys;
}