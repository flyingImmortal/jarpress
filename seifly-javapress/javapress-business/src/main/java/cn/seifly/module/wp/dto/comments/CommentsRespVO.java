package cn.seifly.module.wp.dto.comments;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 文章评论 Response VO")
@Data
@ExcelIgnoreUnannotated
public class CommentsRespVO {

    @Schema(description = "评论id", requiredMode = Schema.RequiredMode.REQUIRED, example = "3850")
    @ExcelProperty("评论id")
    private Long commentId;

    @Schema(description = "文章id", requiredMode = Schema.RequiredMode.REQUIRED, example = "19396")
    @ExcelProperty("文章id")
    private Long commentPostId;

    @Schema(description = "评论者名", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("评论者名")
    private String commentAuthor;

    @Schema(description = "评论者email", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("评论者email")
    private String commentAuthorEmail;

    @Schema(description = "评论者头像url", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @ExcelProperty("评论者头像url")
    private String commentAuthorUrl;

    @Schema(description = "评论者IP", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("评论者IP")
    private String commentAuthorIp;

    @Schema(description = "评论日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("评论日期")
    private LocalDateTime commentDate;

    @Schema(description = "评论时间格林尼治时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("评论时间格林尼治时间")
    private LocalDateTime commentDateGmt;

    @Schema(description = "评论内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("评论内容")
    private String commentContent;

    @Schema(description = "评论点赞数", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("评论点赞数")
    private Integer commentKarma;

    @Schema(description = "审核状态（0待审/1通过）", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("审核状态（0待审/1通过）")
    private String commentApproved;

    @Schema(description = "评论者的客户端信息", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("评论者的客户端信息")
    private String commentAgent;

    @Schema(description = "评论类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("评论类型")
    private String commentType;

    @Schema(description = "父评论id", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("父评论id")
    private Long commentParent;

    @Schema(description = "评论者用户id", requiredMode = Schema.RequiredMode.REQUIRED, example = "30039")
    @ExcelProperty("评论者用户id")
    private Long userId;

}