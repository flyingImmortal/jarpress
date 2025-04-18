package cn.seifly.module.wp.dto.links;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 链接 Response VO")
@Data
@ExcelIgnoreUnannotated
public class LinksRespVO {

    @Schema(description = "链接id", requiredMode = Schema.RequiredMode.REQUIRED, example = "28688")
    @ExcelProperty("链接id")
    private Long linkId;

    @Schema(description = "链接地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @ExcelProperty("链接地址")
    private String linkUrl;

    @Schema(description = "链接名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "")
    @ExcelProperty("链接名称")
    private String linkName;

    @Schema(description = "图片url", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("图片url")
    private String linkImage;

    @Schema(description = "打开方式", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("打开方式")
    private String linkTarget;

    @Schema(description = "描述", requiredMode = Schema.RequiredMode.REQUIRED, example = "你猜")
    @ExcelProperty("描述")
    private String linkDescription;

    @Schema(description = "可见性开关", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("可见性开关")
    private String linkVisible;

    @Schema(description = "链接的创建人", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("链接的创建人")
    private Long linkOwner;

    @Schema(description = "链接等级", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("链接等级")
    private Integer linkRating;

    @Schema(description = "更新时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("更新时间")
    private LocalDateTime linkUpdated;

    @Schema(description = "链接与定义者的关系", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("链接与定义者的关系")
    private String linkRel;

    @Schema(description = "链接的详细说明", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("链接的详细说明")
    private String linkNotes;

    @Schema(description = "链接的RSS地址", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("链接的RSS地址")
    private String linkRss;

}