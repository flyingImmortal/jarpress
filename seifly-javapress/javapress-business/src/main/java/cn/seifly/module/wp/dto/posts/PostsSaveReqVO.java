package cn.seifly.module.wp.dto.posts;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 文章新增/修改 Request VO")
@Data
public class PostsSaveReqVO {

    @Schema(description = "文章id", requiredMode = Schema.RequiredMode.REQUIRED, example = "11616")
    private Long id;

    @Schema(description = "文章作者id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "文章作者id不能为空")
    private Long postAuthor;

    @Schema(description = "创建日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "创建日期不能为空")
    private LocalDateTime postDate;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "创建时间不能为空")
    private LocalDateTime postDateGmt;

    @Schema(description = "内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "内容不能为空")
    private String postContent;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "标题不能为空")
    private String postTitle;

    @Schema(description = "摘要", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "摘要不能为空")
    private String postExcerpt;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "状态不能为空")
    private String postStatus;

    @Schema(description = "评论开关状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "评论开关状态不能为空")
    private String commentStatus;

    @Schema(description = "ping状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "ping状态不能为空")
    private String pingStatus;

    @Schema(description = "文章密码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "文章密码不能为空")
    private String postPassword;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @NotEmpty(message = "名称不能为空")
    private String postName;

    @Schema(description = "ping的链接", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "ping的链接不能为空")
    private String toPing;

    @Schema(description = "已经PING过的链接", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "已经PING过的链接不能为空")
    private String pinged;

    @Schema(description = "修改日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "修改日期不能为空")
    private LocalDateTime postModified;

    @Schema(description = "修改时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "修改时间不能为空")
    private LocalDateTime postModifiedGmt;

    @Schema(description = "过滤后内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "过滤后内容不能为空")
    private String postContentFiltered;

    @Schema(description = "文章父id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "文章父id不能为空")
    private Long postParent;

    @Schema(description = "文章的url地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "16509")
    @NotEmpty(message = "文章的url地址不能为空")
    private String guid;

    @Schema(description = "菜单排序", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "菜单排序不能为空")
    private Integer menuOrder;

    @Schema(description = "文章类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotEmpty(message = "文章类型不能为空")
    private String postType;

    @Schema(description = "附件MIME类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "附件MIME类型不能为空")
    private String postMimeType;

    @Schema(description = "评论总数", requiredMode = Schema.RequiredMode.REQUIRED, example = "13081")
    @NotNull(message = "评论总数不能为空")
    private Long commentCount;

}