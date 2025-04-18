package cn.seifly.module.wp.dto.links;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 链接新增/修改 Request VO")
@Data
public class LinksSaveReqVO {

    @Schema(description = "链接id", requiredMode = Schema.RequiredMode.REQUIRED, example = "28688")
    private Long linkId;

    @Schema(description = "链接地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @NotEmpty(message = "链接地址不能为空")
    private String linkUrl;

    @Schema(description = "链接名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "")
    @NotEmpty(message = "链接名称不能为空")
    private String linkName;

    @Schema(description = "图片url", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "图片url不能为空")
    private String linkImage;

    @Schema(description = "打开方式", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "打开方式不能为空")
    private String linkTarget;

    @Schema(description = "描述", requiredMode = Schema.RequiredMode.REQUIRED, example = "你猜")
    @NotEmpty(message = "描述不能为空")
    private String linkDescription;

    @Schema(description = "可见性开关", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "可见性开关不能为空")
    private String linkVisible;

    @Schema(description = "链接的创建人", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "链接的创建人不能为空")
    private Long linkOwner;

    @Schema(description = "链接等级", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "链接等级不能为空")
    private Integer linkRating;

    @Schema(description = "更新时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "更新时间不能为空")
    private LocalDateTime linkUpdated;

    @Schema(description = "链接与定义者的关系", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "链接与定义者的关系不能为空")
    private String linkRel;

    @Schema(description = "链接的详细说明", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "链接的详细说明不能为空")
    private String linkNotes;

    @Schema(description = "链接的RSS地址", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "链接的RSS地址不能为空")
    private String linkRss;

}