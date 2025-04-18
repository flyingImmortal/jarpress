package cn.seifly.module.wp.dto.comments;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 文章评论新增/修改 Request VO")
@Data
public class CommentsSaveReqVO {

    @Schema(description = "评论id", requiredMode = Schema.RequiredMode.REQUIRED, example = "3850")
    private Long commentId;

    @Schema(description = "文章id", requiredMode = Schema.RequiredMode.REQUIRED, example = "19396")
    @NotNull(message = "文章id不能为空")
    private Long commentPostId;

    @Schema(description = "评论者名", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "评论者名不能为空")
    private String commentAuthor;

    @Schema(description = "评论者email", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "评论者email不能为空")
    private String commentAuthorEmail;

    @Schema(description = "评论者头像url", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @NotEmpty(message = "评论者头像url不能为空")
    private String commentAuthorUrl;

    @Schema(description = "评论者IP", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "评论者IP不能为空")
    private String commentAuthorIp;

    @Schema(description = "评论日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "评论日期不能为空")
    private LocalDateTime commentDate;

    @Schema(description = "评论时间格林尼治时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "评论时间格林尼治时间不能为空")
    private LocalDateTime commentDateGmt;

    @Schema(description = "评论内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "评论内容不能为空")
    private String commentContent;

    @Schema(description = "评论点赞数", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "评论点赞数不能为空")
    private Integer commentKarma;

    @Schema(description = "审核状态（0待审/1通过）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "审核状态（0待审/1通过）不能为空")
    private String commentApproved;

    @Schema(description = "评论者的客户端信息", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "评论者的客户端信息不能为空")
    private String commentAgent;

    @Schema(description = "评论类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "评论类型不能为空")
    private String commentType;

    @Schema(description = "父评论id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "父评论id不能为空")
    private Long commentParent;

    @Schema(description = "评论者用户id", requiredMode = Schema.RequiredMode.REQUIRED, example = "30039")
    @NotNull(message = "评论者用户id不能为空")
    private Long userId;

}