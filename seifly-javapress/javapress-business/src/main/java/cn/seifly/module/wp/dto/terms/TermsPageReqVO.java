package cn.seifly.module.wp.dto.terms;


import cn.seifly.common.core.page.PageParam;
import cn.seifly.common.core.page.PageResult;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Schema(description = "管理后台 - 分类分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)

public class TermsPageReqVO extends PageParam {

    @Schema(description = "名称", example = "王五")
    private String name;

    @Schema(description = "URL别名")
    private String slug;

    @Schema(description = "分类id")
    private Long termGroup;

    @Schema(description = "id列表")
    private List<Long> idList;

    @Schema(description = "类类型名称")
    private String taxonomy;
}