package cn.seifly.module.wp.dto.links;


import cn.seifly.common.core.page.PageParam;
import cn.seifly.common.core.page.PageResult;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 链接分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)

public class LinksPageReqVO extends PageParam {

    @Schema(description = "链接地址", example = "https://www.iocoder.cn")
    private String linkUrl;

    @Schema(description = "链接名称", example = "")
    private String linkName;

    @Schema(description = "图片url")
    private String linkImage;

    @Schema(description = "打开方式")
    private String linkTarget;

    @Schema(description = "描述", example = "你猜")
    private String linkDescription;

    @Schema(description = "可见性开关")
    private String linkVisible;

    @Schema(description = "链接的创建人")
    private Long linkOwner;

    @Schema(description = "链接等级")
    private Integer linkRating;

    @Schema(description = "更新时间")
    private LocalDateTime linkUpdated;

    @Schema(description = "链接与定义者的关系")
    private String linkRel;

    @Schema(description = "链接的详细说明")
    private String linkNotes;

    @Schema(description = "链接的RSS地址")
    private String linkRss;

}