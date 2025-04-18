package cn.seifly.module.wp.dto.comments;

import cn.seifly.common.core.page.PageParam;
import cn.seifly.common.core.page.PageResult;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

import static cn.seifly.common.utils.DateUtils.YYYY_MM_DD_HH_MM_SS;


@Schema(description = "管理后台 - 文章评论分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)

public class CommentsPageReqVO extends PageParam {

    @Schema(description = "文章id", example = "19396")
    private Long commentPostId;

    @Schema(description = "评论者名")
    private String commentAuthor;

    @Schema(description = "评论者email")
    private String commentAuthorEmail;

    @Schema(description = "评论者头像url", example = "https://www.iocoder.cn")
    private String commentAuthorUrl;

    @Schema(description = "评论者IP")
    private String commentAuthorIp;

    @Schema(description = "评论日期")
    @DateTimeFormat(pattern = YYYY_MM_DD_HH_MM_SS)
    private LocalDateTime[] commentDate;

    @Schema(description = "评论时间格林尼治时间")
    private LocalDateTime commentDateGmt;

    @Schema(description = "评论内容")
    private String commentContent;

    @Schema(description = "评论点赞数")
    private Integer commentKarma;

    @Schema(description = "审核状态（0待审/1通过）")
    private String commentApproved;

    @Schema(description = "评论者的客户端信息")
    private String commentAgent;

    @Schema(description = "评论类型", example = "1")
    private String commentType;

    @Schema(description = "父评论id")
    private Long commentParent;

    @Schema(description = "评论者用户id", example = "30039")
    private Long userId;

    @Schema(description = "id列表")
    private List<Long> idList;

}