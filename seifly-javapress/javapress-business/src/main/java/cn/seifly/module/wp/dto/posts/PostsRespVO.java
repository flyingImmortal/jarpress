package cn.seifly.module.wp.dto.posts;

import cn.seifly.module.wp.api.dataobject.comments.CommentsDTO;
import cn.seifly.module.wp.api.dataobject.terms.TermsDTO;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - 文章 Response VO")
@Data
@ExcelIgnoreUnannotated
public class PostsRespVO {

    @Schema(description = "文章id", requiredMode = Schema.RequiredMode.REQUIRED, example = "11616")
    @ExcelProperty("文章id")
    private Long id;

    @Schema(description = "文章作者id", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("文章作者id")
    private Long postAuthor;

    @Schema(description = "创建日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建日期")
    private LocalDateTime postDate;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime postDateGmt;

    @Schema(description = "内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("内容")
    private String postContent;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("标题")
    private String postTitle;

    @Schema(description = "摘要", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("摘要")
    private String postExcerpt;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("状态")
    private String postStatus;

    @Schema(description = "评论开关状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("评论开关状态")
    private String commentStatus;

    @Schema(description = "ping状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("ping状态")
    private String pingStatus;

    @Schema(description = "文章密码", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("文章密码")
    private String postPassword;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @ExcelProperty("名称")
    private String postName;

    @Schema(description = "ping的链接", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("ping的链接")
    private String toPing;

    @Schema(description = "已经PING过的链接", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("已经PING过的链接")
    private String pinged;

    @Schema(description = "修改日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("修改日期")
    private LocalDateTime postModified;

    @Schema(description = "修改时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("修改时间")
    private LocalDateTime postModifiedGmt;

    @Schema(description = "过滤后内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("过滤后内容")
    private String postContentFiltered;

    @Schema(description = "文章父id", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("文章父id")
    private Long postParent;

    @Schema(description = "文章的url地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "16509")
    @ExcelProperty("文章的url地址")
    private String guid;

    @Schema(description = "菜单排序", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("菜单排序")
    private Integer menuOrder;

    @Schema(description = "文章类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("文章类型")
    private String postType;

    @Schema(description = "附件MIME类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("附件MIME类型")
    private String postMimeType;

    @Schema(description = "评论总数", requiredMode = Schema.RequiredMode.REQUIRED, example = "13081")
    @ExcelProperty("评论总数")
    private Long commentCount;

}