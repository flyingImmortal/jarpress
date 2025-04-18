package cn.seifly.module.wp.dto.posts;


import cn.seifly.common.core.page.PageParam;
import cn.seifly.common.core.page.PageResult;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

import static cn.seifly.common.utils.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


@Schema(description = "管理后台 - 文章分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)

public class PostsPageReqVO extends PageParam {

    @Schema(description = "文章id")
    private Long id;

    @Schema(description = "文章作者id")
    private Long postAuthor;

    @Schema(description = "创建日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] postDate;

    @Schema(description = "创建时间")
    private LocalDateTime postDateGmt;

    @Schema(description = "内容")
    private String postContent;

    @Schema(description = "标题")
    private String postTitle;

    @Schema(description = "摘要")
    private String postExcerpt;

    @Schema(description = "状态", example = "1")
    private String postStatus;

    @Schema(description = "评论开关状态", example = "1")
    private String commentStatus;

    @Schema(description = "ping状态", example = "1")
    private String pingStatus;

    @Schema(description = "文章密码")
    private String postPassword;

    @Schema(description = "名称", example = "李四")
    private String postName;

    @Schema(description = "ping的链接")
    private String toPing;

    @Schema(description = "已经PING过的链接")
    private String pinged;

    @Schema(description = "修改日期")
    private LocalDateTime postModified;

    @Schema(description = "修改时间")
    private LocalDateTime postModifiedGmt;

    @Schema(description = "过滤后内容")
    private String postContentFiltered;

    @Schema(description = "文章父id")
    private Long postParent;

    @Schema(description = "文章的url地址", example = "16509")
    private String guid;

    @Schema(description = "菜单排序")
    private Integer menuOrder;

    @Schema(description = "文章类型", example = "2")
    private String postType;

    @Schema(description = "附件MIME类型", example = "1")
    private String postMimeType;

    @Schema(description = "评论总数", example = "13081")
    private Long commentCount;

    @Schema(description = "id列表")
    private List<Long> idList;

    @Schema(description = "排序名称", example = "likes")
    private String sort;

    @Schema(description = "文章父id")
    private Long nextPostId;
    @Schema(description = "文章父id")
    private Long prePostId;
}